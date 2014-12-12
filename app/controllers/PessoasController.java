package controllers;

import models.*;
import models.objects.FornecedorComplemento;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by heatd_000 on 11/12/2014.
 */
public class PessoasController extends Controller {

    public static Result index() {
        return ok(
                Json.toJson(
                        Pessoa.find.all()));
    }

    public static Result create() {
        String DTYPE = request().getHeader("clientType");
        Pessoa p=null;
        switch (DTYPE) {
            case "F" :
                p  = Json.fromJson(request().body().asJson(), Fornecedor.class);
                break;
            case "C" :
                p  = Json.fromJson(request().body().asJson(), Cliente.class);
                break;
            case "P" :
                p  = Json.fromJson(request().body().asJson(), Pessoa.class);
                break;
            default :

        }
        if(p != null) {
            p.save();
            return created();
        }
        return status(500);
    }

    public static Result createContato(Long id) {
        Contato c  = Json.fromJson(
                request().body().asJson(), Contato.class);
        Pessoa p =
        Pessoa.find.byId(id);
        c.pessoa = p;

        c.save();

        return noContent();
    }

    public static Result createPerfil(Long id) {
        Perfil p  = Json.fromJson(
                request().body().asJson(), Perfil.class);
        p.setId(id);
        p.save();

        return noContent();
    }

    public static Result createComplemento(Long id) {
        Fornecedor f = (Fornecedor) Pessoa.find.byId(id);

        FornecedorComplemento complemento = Json.fromJson(
                request().body().asJson(), FornecedorComplemento.class);

        complemento.setFornecedor(f);

        complemento.save();

        return create();
    }
}
