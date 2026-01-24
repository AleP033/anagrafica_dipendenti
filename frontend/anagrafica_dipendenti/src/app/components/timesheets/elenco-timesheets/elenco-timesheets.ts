import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Timesheet } from '../../../models/Timesheet/timesheet';
import { TimesheetService } from '../../../services/Timesheet/timesheet.service';

@Component({
  selector: 'app-elenco-timesheets',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './elenco-timesheets.html',
  styleUrl: './elenco-timesheets.css',
})
export class ElencoTimesheets implements OnInit {

  timesheets: Timesheet[] = [];

  constructor(private timService: TimesheetService) {}

  ngOnInit(): void {
    this.timService.getTimesheet().subscribe({
      next: (data) => {
        this.timesheets = data;
      },
      error: (err) => {
        console.error("Errore nel recupero dei timesheets", err);
      }
    });
  }
}
