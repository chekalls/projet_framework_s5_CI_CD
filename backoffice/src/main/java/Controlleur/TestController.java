package Controlleur;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import entity.Departement;
import entity.Etudiant;
import entity.Matiere;
import mg.miniframework.annotation.Controller;
import mg.miniframework.annotation.UrlMap;
import mg.miniframework.annotation.UrlParam;
import mg.miniframework.annotation.GetMapping;
import mg.miniframework.annotation.PostMapping;
import mg.miniframework.annotation.JsonUrl;
import mg.miniframework.annotation.RequestAttribute;
import mg.miniframework.modules.File;
import mg.miniframework.modules.ModelView;

@Controller
public class TestController {

    @PostMapping
    @UrlMap(value = "/sprint10")
    public ModelView sprint10Post(Map<String, Object> requestData, Map<Path,File> filesMap) {

        if (filesMap == null) {
            filesMap = Collections.<Path, File>emptyMap();
        }

        for(Map.Entry<Path,File> file : filesMap.entrySet()){
            file.getValue().save();
        }

        ModelView mv = new ModelView();
        mv.setView("sprint10result.jsp");

        Map<String, Object> data = new HashMap<>();
        data.put("requestData", requestData);
        data.put("fileMap", filesMap);

        mv.setData("data", data);
        mv.setView("/sprint10Result.jsp");

        return mv;
    }

    @GetMapping
    @UrlMap(value = "/sprint10")
    public ModelView sprint10() {
        ModelView modelView = new ModelView();
        modelView.setView("sprint10.jsp");
        return modelView;
    }

    @PostMapping
    @UrlMap(value = "/sprint8Post")
    public ModelView sprint8Post(Map<String, Object> requestData) {
        ModelView modelView = new ModelView();
        modelView.setView("sprint8result.jsp");
        modelView.setData("requestData", requestData);
        return modelView;
        // StringBuilder builder = new StringBuilder();
        // for (Map.Entry<String,Object> element : requestData.entrySet()) {
        // builder.append(element.getKey()+ " --------- value "
        // +((String)element.getValue())+" | ");
        // }
        // return builder.toString();
    }

    @JsonUrl
    @PostMapping
    @UrlMap(value = "/sprint8ObjectPost")
    public ModelView sprint8formObjectTraitement(Etudiant etudiant, Departement departement, Matiere[] matieres) {
        ModelView mv = new ModelView();
        mv.setData("etudiant", etudiant);
        mv.setData("departement", departement);
        mv.setView("sprint8formObjectResult.jsp");
        return mv;
    }

    @GetMapping
    @UrlMap(value = "/sprint8Object")
    public ModelView sprint8formObject() {
        ModelView modelView = new ModelView();
        modelView.setView("sprint8formObject.jsp");
        return modelView;
    }

    @GetMapping
    @UrlMap(value = "/sprint8form")
    public ModelView sprint8Form() {
        ModelView modelView = new ModelView();
        modelView.setView("sprint8.jsp");
        return modelView;
    }

    @GetMapping
    @UrlMap(value = "/methodTest")
    public String simpleMessage() {
        return "ito misy mofogasy";
    }

    @GetMapping
    @UrlMap(value = "/sprint7form")
    public ModelView form() {
        ModelView mv = new ModelView();
        mv.setView("sprint7.jsp");
        return mv;
    }

    @PostMapping
    @UrlMap(value = "/sprint7post")
    public String formTraitement(String exemple) {
        return exemple;
    }

    // @JsonUrl
    @GetMapping
    @UrlMap(value = "/sprint6ter/{idEtudiant}")
    public ModelView testUrlVariable(@UrlParam(name = "idEtudiant") String idEtu) {
        ModelView mv = new ModelView();
        mv.setView("test.jsp");
        mv.setData("idEtudiant", idEtu);
        return mv;
    }

    @GetMapping
    @UrlMap(value = "/sprint6bis")
    public ModelView detailsWithRequestParam(
            @RequestAttribute(paramName = "etu") String numeroEtudiant) {

        ModelView mv = new ModelView();
        mv.setView("etudiants-details.jsp");
        mv.setData("etu", numeroEtudiant);
        return mv;
    }

    @GetMapping
    @UrlMap(value = "/sprint6")
    public ModelView detailsModelView(String etu) {
        ModelView mv = new ModelView();
        mv.setView("etudiants-details.jsp");
        mv.setData("etu", etu);
        return mv;
    }

    @GetMapping
    @UrlMap(value = "/sprint5")
    public ModelView listEtudiants() {
        Etudiant[] etudiants = {
                new Etudiant("etu1", "prn1"),
                new Etudiant("etu2", "prn2")
        };

        ModelView mv = new ModelView();
        mv.setView("etudiants.jsp");
        mv.setData("etudiants", new ArrayList<>(Arrays.asList(etudiants)));

        return mv;
    }

    @GetMapping
    @UrlMap(value = "/sprint4bis")
    public ModelView simpleTestView() {
        ModelView mv = new ModelView();
        mv.setView("test.jsp");
        return mv;
    }
}