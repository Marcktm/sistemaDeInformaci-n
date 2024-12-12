package com.supercharger.command;

import com.supercharger.dao.TurnoDAO;
import com.supercharger.model.Turno;

public class ConfirmarTurnoCommand {
    private final Turno turno;

    public ConfirmarTurnoCommand(Turno turno) {
        this.turno = turno;
    }

    public void execute() {
        TurnoDAO turnoDAO = new TurnoDAO();
        turnoDAO.guardarTurno(turno);
    }
}
