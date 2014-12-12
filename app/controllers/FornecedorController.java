package controllers;

import models.*;
import models.objects.FornecedorComplemento;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class FornecedorController extends Controller{


    public static Result todos() {
        return ok(
                Json.toJson(Fornecedor.find.all()));
    }

    public static Result create() {
        String DTYPE = request().getHeader("clientType");
        Fornecedor p =null;
        switch (DTYPE) {
            case "F" :
                p  = Json.fromJson(request().body().asJson(), Fornecedor.class);
                break;
            case "I" :
                FornecedorInterno i  = Json.fromJson(request().body().asJson(), FornecedorInterno.class);
                Setor s = Setor.find.byId(i.setor.id);
                i.setor = s;
                p = i;
                break;
            default :

        }
        if(p != null) {
            p.save();
            return created();
        }
        return status(500);
    }


    public static Result createComplemento(Long id) {
        Fornecedor f = Fornecedor.find.byId(
                new FornecedorKey(id));

        FornecedorComplemento complemento = Json.fromJson(
                request().body().asJson(), FornecedorComplemento.class);

        complemento.fornecedor = f;

        f.complemento = complemento;

        complemento.save();

        return create();
    }

    public static Result createSetor() {
        Setor s = Json.fromJson(
                request().body().asJson(), Setor.class);
        s.save();
        return created();
    }

}
