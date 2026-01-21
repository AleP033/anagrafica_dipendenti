import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoContratti } from './elenco-contratti';

describe('ElencoContratti', () => {
  let component: ElencoContratti;
  let fixture: ComponentFixture<ElencoContratti>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElencoContratti]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElencoContratti);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
