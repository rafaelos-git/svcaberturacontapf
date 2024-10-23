package com.santander.svcaberturaconta.adapters.out.client;

import com.santander.svcaberturaconta.adapters.out.client.response.ValidaCpfResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "EnviarCpfParaValidacaoClient",
        url = "${santander.client.cpf.url}"
)
public interface EnviarCpfParaValidacaoClient {
    @GetMapping("/{cpf}")
    ValidaCpfResponse enviar(@PathVariable("cpf") String cpf);
}
