import { Routes } from '@angular/router';
import { ElencoDipendenti } from './components/dipendenti/elenco-dipendenti/elenco-dipendenti';
import { ElencoResponsabili } from './components/responsabili/elenco-responsabili/elenco-responsabili';
import { ElencoContratti } from './components/contratti/elenco-contratti/elenco-contratti';
import { ElencoCommesse } from './components/commesse/elenco-commesse/elenco-commesse';
import { ElencoTimesheets } from './components/timesheets/elenco-timesheets/elenco-timesheets';

export const routes: Routes = [
    {
        path: 'dipendenti',
        component: ElencoDipendenti
    },
        {
        path: 'responsabili',
        component: ElencoResponsabili
    },
        {
        path: 'contratti',
        component: ElencoContratti
    },
        {
        path: 'commesse',
        component: ElencoCommesse
    },
        {
        path: 'timesheets',
        component: ElencoTimesheets
    },
    {
        path: " ",
        redirectTo: 'dipendenti',
        pathMatch: 'full'
    }
];