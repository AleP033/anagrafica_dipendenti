import { Commessa } from "../Commessa/commessa";
import { Dipendente } from "../Dipendente/dipendente";

export class Timesheet {

    id? : number;
    oreLavorate? : number;
    data? : string;
    tipologia? : string;

    dipendente? : Dipendente;
    commessa? : Commessa
}
