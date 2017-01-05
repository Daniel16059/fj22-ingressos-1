package br.com.caelum.ingresso.modelo;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nando on 04/01/17.
 */
public class SalaTest {


    @Test
    public void garanteQueNaoDevePermitirSessaoNoMesmoHorario(){
        Sala sala = new Sala("teste");
        Filme filme = new Filme();
        filme.setDuracao(120);
        LocalTime horario = LocalTime.now();


        List<Sessao> sessoes = Arrays.asList(new Sessao(horario, filme));

        sala.setSessoes(sessoes);

        Assert.assertFalse(sala.temHorarioDisponivel(horario, filme));
    }

    @Test
    public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente(){
        Sala sala = new Sala("teste");
        Filme filme = new Filme();
        filme.setDuracao(120);
        LocalTime horario = LocalTime.now();

        List<Sessao> sessoes = Arrays.asList(new Sessao(horario, filme));

        sala.setSessoes(sessoes);


        Assert.assertFalse(sala.temHorarioDisponivel(horario.minus(1, ChronoUnit.HOURS), filme));

    }


    @Test
    public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente(){
        Sala sala = new Sala("teste");
        Filme filme = new Filme();
        filme.setDuracao(120);
        LocalTime horario = LocalTime.now();

        List<Sessao> sessoes = Arrays.asList(new Sessao(horario, filme));

        sala.setSessoes(sessoes);

        Assert.assertFalse(sala.temHorarioDisponivel(horario.plus(1,ChronoUnit.HOURS), filme));

    }
}