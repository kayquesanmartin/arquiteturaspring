package io.github.kayquesanmartin.arquiteturaspring.montadora.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kayquesanmartin.arquiteturaspring.montadora.CarroStatus;
import io.github.kayquesanmartin.arquiteturaspring.montadora.Chave;
import io.github.kayquesanmartin.arquiteturaspring.montadora.HondaHRV;
import io.github.kayquesanmartin.arquiteturaspring.montadora.Motor;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired // injeta a instancia de motor
    //@Qualifier("motorTurbo") // injeta a instancia de motorTurbo
    @Turbo
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }

}
