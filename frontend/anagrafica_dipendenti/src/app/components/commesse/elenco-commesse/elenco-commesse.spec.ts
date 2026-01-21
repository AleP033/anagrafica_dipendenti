import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoCommesse } from './elenco-commesse';

describe('ElencoCommesse', () => {
  let component: ElencoCommesse;
  let fixture: ComponentFixture<ElencoCommesse>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElencoCommesse]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElencoCommesse);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
