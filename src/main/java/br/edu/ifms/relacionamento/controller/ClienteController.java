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

import br.edu.ifms.relacionamento.dto.ClienteAndServicoRespDto;
import br.edu.ifms.relacionamento.dto.ClienteServicoMappingDto;
import br.edu.ifms.relacionamento.entity.Cliente;
import br.edu.ifms.relacionamento.dto.ClienteRequestDto;
import br.edu.ifms.relacionamento.dto.ClienteResponseDto;
import br.edu.ifms.relacionamento.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Cliente Controller", value = "This section contains cliente specific operations")
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Add new cliente", notes = "Add new cliente")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteResponseDto> saveCliente(@RequestBody ClienteRequestDto clienteDto) {

		ClienteResponseDto cliente = clienteService.createCliente(clienteDto);

		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Add servico to the cliente", notes = "Add projeto to the cliente")
	@PostMapping(value = "/add-servico", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addServicoToCliente(@RequestBody ClienteServicoMappingDto clienteServicoMappingDto) {
		clienteService.addServicoToCliente(clienteServicoMappingDto.getClienteId(),
				clienteServicoMappingDto.getServicoIds());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Get Servico by Id", notes = "Get servico by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteAndServicoRespDto> getClienteById(@PathVariable final Integer id) {
		ClienteAndServicoRespDto clienteAndServicoRespDto = clienteService.getClienteDetails(id);
		return new ResponseEntity<>(clienteAndServicoRespDto, HttpStatus.OK);
	}
    /* @GetMapping("/clientes")
    public ModelAndView getCliente(){
    ModelAndView mv = new ModelAndView("clienteTemplate");
     mv.addObject("cliente",  new Cliente());
      mv.addObject("clientes", clienteService.getClientes());
        mv.addObject("servicos", servicoServico.getServicos());
        return mv;
    }

    @GetMapping("/removerCliente")
    public String removerCliente(@RequestParam Integer inscricao){
    Cliente cliente = clienteServico.getClienteoById(inscricao);
    clienteService.remover(cliente);
    return "redirect:/cliente";
    } */


    @PostMapping("/salvarCliente")
    public String salvar(@ModelAttribute Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    
}
