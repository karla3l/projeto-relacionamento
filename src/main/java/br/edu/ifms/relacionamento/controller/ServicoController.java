package br.edu.ifms.relacionamento.controller;

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

import br.edu.ifms.relacionamento.dto.ServicoRequestDto;
import br.edu.ifms.relacionamento.dto.ServicoResponseDto;
import br.edu.ifms.relacionamento.entity.Servico;
import br.edu.ifms.relacionamento.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Servico Controller", value = "This section contains Servico specific operations")
@RequestMapping(value = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	@ApiOperation(value = "Create new servico", notes = "Create new servico")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicoResponseDto> saveServico(@RequestBody ServicoRequestDto servicoDto) {

		ServicoResponseDto servico = servicoService.createServico(servicoDto);

		return new ResponseEntity<>(servico, HttpStatus.CREATED);
	}

	@GetMapping("/informacoesServico/{id}")
    public ModelAndView getServicoInformacoes(@PathVariable(name = "id") Integer id) {
        
        Servico servico = ((Servico) servicoService).getProjetoById(id);
        ModelAndView mv = new ModelAndView("informacoesServico");
        mv.addObject("servico", servico);

        return mv;
    }
}
