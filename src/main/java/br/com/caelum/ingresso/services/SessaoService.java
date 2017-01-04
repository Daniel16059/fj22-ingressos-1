package br.com.caelum.ingresso.services;

import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sessao;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SessaoService {

    public boolean temHorarioDisponivel(LocalTime horario, Filme filme, List<Sessao> sessoesDoCinema) {
        for (Sessao sessaoDoCinema : sessoesDoCinema) {
            if (! horarioIsValido(horario, filme, sessaoDoCinema)) {
                return false;
            }
        }
        return true;
    }

    private boolean horarioIsValido(LocalTime horarioAtual, Filme filme, Sessao sessao) {

        LocalTime horarioSessao = sessao.getHorario();


        if (horarioAtual.compareTo(sessao.getHorario()) == 0) return false;

        boolean ehAntes = horarioAtual.isBefore(horarioSessao);

        if (ehAntes){
            long tempoDisponivel = horarioAtual.until(horarioSessao, ChronoUnit.MINUTES);

            long duracaoDoFilme = filme.getDuracao().toMinutes();

            return duracaoDoFilme <= tempoDisponivel;
        }else {

            LocalTime horarioTermino = sessao.getHorarioTermino();

            long tempoDisponivel = horarioAtual.until(horarioTermino, ChronoUnit.MINUTES);

            return  tempoDisponivel >= filme.getDuracao().toMinutes();

        }
    }
}