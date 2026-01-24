import { TestBed } from '@angular/core/testing';

import {CommessaService} from './commessa.service';
describe('Commessa', () => {
  let service: CommessaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommessaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
