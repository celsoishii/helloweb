package br.com.isidrocorp.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.hello.model.Usuario;

@RestController
public class UserController {

	// quero fazer um login mock

	@PostMapping("/login")
		public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dadosLogin) {
		//testando usuario existe
		if (dadosLogin.getRacf().equals("isidro")) {
			//testando se senha ok
					if (dadosLogin.getSenha().equals("1234")) {
			
				//usuario existe, retorna 200 0 o + o objeto usuario preenchido		
				Usuario resposta = new Usuario();
				resposta.setId(36854);
				resposta.setNome("Professor Isidro");
				resposta.setEmail("isidro@isidro.com");
				resposta.setRacf("isidro");
				resposta.setFuncional("96854712354");
				resposta.setDepartamento("Treinamento/DEV");
				return ResponseEntity.ok(resposta);
			}
					//senha não confere, retorno 401 (unathorized)
			return ResponseEntity.status(401).build();
		
		
	}
		//usuario não existe, retorno codigo http 404
	return ResponseEntity.status(404).build();
}

}
