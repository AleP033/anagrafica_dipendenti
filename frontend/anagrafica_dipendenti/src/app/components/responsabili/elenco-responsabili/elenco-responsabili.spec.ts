import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoResponsabili } from './elenco-responsabili';

describe('ElencoResponsabili', () => {
  let component: ElencoResponsabili;
  let fixture: ComponentFixture<ElencoResponsabili>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElencoResponsabili]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElencoResponsabili);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
