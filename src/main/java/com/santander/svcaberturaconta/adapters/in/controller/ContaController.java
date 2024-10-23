package com.santander.svcaberturaconta.adapters.in.controller;

import com.santander.svcaberturaconta.adapters.in.controller.mapper.ContaMapper;
import com.santander.svcaberturaconta.adapters.in.controller.request.ContaRequest;
import com.santander.svcaberturaconta.application.ports.in.CadastrarContaInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {
    @Autowired
    private CadastrarContaInputPort cadastrarContaInputPort;

    @Autowired
    private ContaMapper contaMapper;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody ContaRequest contaRequest) {
        var conta = contaMapper.toConta(contaRequest);
        cadastrarContaInputPort.cadastrar(conta, contaRequest.getCep());
        return ResponseEntity.ok().build();
    }
}
