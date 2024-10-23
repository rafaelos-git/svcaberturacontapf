package com.santander.svcaberturaconta.adapters.out.client;

import com.santander.svcaberturaconta.adapters.out.client.response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ConsultarEnderecoPorCepClient",
        url = "${santander.client.endereco.url}"
)
public interface ConsultarEnderecoPorCepClient {
    @GetMapping("/{cep}")
    EnderecoResponse consultar(@PathVariable("cep") String cep);
}
