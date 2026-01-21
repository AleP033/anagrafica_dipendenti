import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoTimesheets } from './elenco-timesheets';

describe('ElencoTimesheets', () => {
  let component: ElencoTimesheets;
  let fixture: ComponentFixture<ElencoTimesheets>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElencoTimesheets]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElencoTimesheets);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
