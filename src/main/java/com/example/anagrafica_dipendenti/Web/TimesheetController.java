package com.example.anagrafica_dipendenti.Web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anagrafica_dipendenti.Model.Timesheet;
import com.example.anagrafica_dipendenti.Service.TimesheetService;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {
    private final TimesheetService timesheetService;
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    //Ritorna una lista con tutti i timesheet
    @GetMapping
    public List<Timesheet> getAll() {
        return timesheetService.findAll();
    }

    //Ricerca per Id
    @GetMapping("/{id}")
    public Timesheet getById(Long timesheetId) {
        return timesheetService.findById(timesheetId);
    }

    //POST per inserire
    @PostMapping
    public Timesheet insert(@RequestBody Timesheet t) {
        return timesheetService.insert(t);
    }

    //POST per associare un dipendente
    @PostMapping("/{timesheetId}/dipendente/{dipendenteId}")
    public Timesheet addDipendente(@PathVariable Long dipendenteId, @PathVariable Long timesheetId){
        return timesheetService.addDipendente(dipendenteId, timesheetId);
    }

    //POST per associare una commessa
    @PostMapping("/{timesheetId}/commessa/{commessaId}")
    public Timesheet addCommessa(@PathVariable Long commessaId, @PathVariable Long timesheetId){
        return timesheetService.addCommessa(commessaId, timesheetId);
    }
 
}
