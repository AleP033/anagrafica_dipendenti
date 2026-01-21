import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoDipendenti } from './elenco-dipendenti';

describe('ElencoDipendenti', () => {
  let component: ElencoDipendenti;
  let fixture: ComponentFixture<ElencoDipendenti>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElencoDipendenti]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElencoDipendenti);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
