package controllers;

import models.Tarea;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;


import javax.inject.Inject;
import java.util.List;

public class TareaController extends Controller {
    @Inject
    private FormFactory formFactory;

    //obtener las tareas
    public Result index() {
        List<Tarea> tareas = Tarea.find.all();
        return ok(views.html.tareas.index.render(tareas));
    }

    //crear una nueva tarea
    public Result create() {
        Form<Tarea> tareaForm = formFactory.form(Tarea.class);
        return ok(views.html.tareas.crearTareas.render(tareaForm));
    }

    //guardar una nueva tarea
    public Result save(Http.Request request) {
        Form<Tarea>  tareaForm = formFactory.form(Tarea.class).bindFromRequest(request);
        if(tareaForm.hasErrors()) {
            return badRequest(views.html.tareas.crearTareas.render(tareaForm));
        }
        Tarea tarea = tareaForm.get();
        tarea.save();
        return redirect(routes.TareaController.index());
    }

    //Mostrar datos de una tarea
    public Result show(Long id) {
        Tarea tarea = Tarea.find.byId(id);
        if(tarea == null) {
            return notFound("Tarea no encontrada");
        }
        return ok(views.html.tareas.detalleTarea.render(tarea));
    }

    //editar tareas
    public Result edit(Long id) {
        Tarea tarea = Tarea.find.byId(id);
        if (tarea == null) {
            return notFound("Tarea no encontrada");
        }
        Form<Tarea> tareaForm = formFactory.form(Tarea.class).fill(tarea);
        return ok(views.html.tareas.editarTarea.render(tareaForm, id));
    }

    //actualizar
    public Result update(Long id, Http.Request request) {
        Form<Tarea> tareaForm = formFactory.form(Tarea.class).bindFromRequest(request);
        if(tareaForm.hasErrors()) {
            return badRequest(views.html.tareas.editarTarea.render(tareaForm, id));
        }
        Tarea tarea = tareaForm.get();
        tarea.id = id;
        tarea.update();
        return redirect(routes.TareaController.index());
    }

    //Eliminar una tarea
    public Result delete(Long id) {
        Tarea tarea = Tarea.find.byId(id);
        if(tarea == null) {
            return notFound("Tarea no encontrada");
        }
        tarea.delete();
        return redirect(routes.TareaController.index());
    }
}
