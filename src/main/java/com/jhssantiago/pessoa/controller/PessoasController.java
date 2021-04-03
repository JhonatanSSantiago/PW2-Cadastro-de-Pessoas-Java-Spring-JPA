package com.jhssantiago.pessoa.controller;

import com.jhssantiago.pessoa.dao.PessoaFisicaRepository;
import com.jhssantiago.pessoa.model.PessoaFisica;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jhons
 */
@Transactional
@Controller
@RequestMapping("pessoas")
public class PessoasController {
    
    
    @Autowired
    PessoaFisicaRepository repository;

    /**
     * @param pessoaFisica necessário devido utilizar no form.html o th:object que faz
     * referência ao objeto esperado no controller.
     * @return
     */
    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica) {
        return "/pessoas/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoas", repository.pessoaFisica());
        return new ModelAndView("/pessoas/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaFisica pessoaFisica) {
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoas/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada
     * diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {
        repository.remove(id);
        return new ModelAndView("redirect:/pessoas/list");
    }

    /**
     * @param id
     * @param model
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada
     * diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("pessoaFisica", repository.pessoaFisica(id));
        return new ModelAndView("/pessoas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoas/list");
    }

}
