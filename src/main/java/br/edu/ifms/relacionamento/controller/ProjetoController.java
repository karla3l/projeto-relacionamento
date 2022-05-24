package br.edu.ifms.relacionamento.controller;

import com.google.common.util.concurrent.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.relacionamento.dto.ProjetoRequestDto;
import br.edu.ifms.relacionamento.dto.ProjetoResponseDto;
import br.edu.ifms.relacionamento.entity.Projeto;
import br.edu.ifms.relacionamento.entity.Servico;
import br.edu.ifms.relacionamento.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Projeto Controller", value = "This section contains Projeto specific operations")
@RequestMapping(value = "/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@ApiOperation(value = "Create new projeto", notes = "Create new projeto")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjetoResponseDto> saveProjeto(@RequestBody ProjetoRequestDto projetoDto) {

		ProjetoResponseDto projeto = projetoService.createProjeto(projetoDto);

		return new ResponseEntity<>(projeto, HttpStatus.CREATED);
	}

	@GetMapping("/informacoes/{id}")
    public ModelAndView getProjetoInformacoes(@PathVariable(name = "id") Integer id) {
        
        //Projeto projeto = service.getProjetoById(id);
		Projeto projeto = ((Projeto) projetoService).getProjetoById(id);
        ModelAndView mv = new ModelAndView("informacoesProjeto");
        mv.addObject("projeto", projeto);

        return mv;
    }
}