package br.edu.ifms.relacionamento.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.relacionamento.dto.FuncionarioAndProjetoRespDto;
import br.edu.ifms.relacionamento.dto.FuncionarioProjetoMappingDto;
import br.edu.ifms.relacionamento.dto.FuncionarioRequestDto;
import br.edu.ifms.relacionamento.dto.FuncionarioResponseDto;
import br.edu.ifms.relacionamento.entity.Funcionario;
import br.edu.ifms.relacionamento.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Funcionario Controller", value = "This section contains funcionario specific operations")
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@ApiOperation(value = "Add new funcionario", notes = "Add new funcionario")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FuncionarioResponseDto> saveFuncionario(@RequestBody FuncionarioRequestDto funcionarioDto) {

		FuncionarioResponseDto funcionario = funcionarioService.createFuncionario(funcionarioDto);

		return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Add projeto to the funcionario", notes = "Add projeto to the funcionario")
	@PostMapping(value = "/add-projeto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addProjetoToFuncionario(@RequestBody FuncionarioProjetoMappingDto funcionarioProjetoMappingDto) {
		funcionarioService.addProjetosToFuncionario(funcionarioProjetoMappingDto.getFuncionarioId(),
				funcionarioProjetoMappingDto.getProjetoIds());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Get Projeto by Id", notes = "Get projeto by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FuncionarioAndProjetoRespDto> getFuncionarioById(@PathVariable final Integer id) {
		FuncionarioAndProjetoRespDto funcionarioAndProjetoRespDto = funcionarioService.getFuncionarioDetails(id);
		return new ResponseEntity<>(funcionarioAndProjetoRespDto, HttpStatus.OK);
	}

	/* @GetMapping("/funcionarios")
    public ModelAndView getFuncionario(){
        
        ModelAndView mv = new ModelAndView("funcionarioTemplate");
    
        mv.addObject("funcionario",  new Funcionario());
        mv.addObject("funcionarios", funcionarioService.getFuncionarios());
        mv.addObject("projetos", projetoServico.getProjetos());
        
        return mv;
    }

    @GetMapping("/removerFuncionario")
    public String removerFuncionario(@RequestParam Integer inscricao){
    Funcionario funcionario = funcionarioServico.getFuncionariooById(inscricao);
	funcionarioService.remover(funcionario);
	return "redirect:/funcionario";
    } */

    @PostMapping("/salvarFuncionario")
    public String salvar(@ModelAttribute Funcionario funcionario){
        funcionarioService.save(funcionario);
        return "redirect:/funcionarios";
    }
}