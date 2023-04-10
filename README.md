# PowPaw

Platform Fighting Game per il progetto di Programmazione ad Oggetti Università di Bologna sede Cesena.

---

#### CONTATTI:

- alessia.carfi@studio.unibo.it
- simone.collora@studio.unibo.it
- giacomo.grassetti@studio.unibo.it

## OBIETTIVO

Il gruppo si pone l'obiettivo di creare un **Platform Fighting Game** in stile _Super Smash Bros_ o _Brawlhalla_. Lo scopo del gioco è battere il tuo avversario in una battaglia `1 vs 1`.

Prima del combattimento si avrà la possibilità di personalizzare le statistiche del proprio personaggio giocabile; nello specifico il personaggio avrà dei _punti statistica_ di base e dei _punti statistica aggiuntivi_ da potere sommare a quest'ultime a proprio piacimento.
Durante la battaglia, cadranno _oggetti_ dall'alto e ogni giocatore potrà raccoglierli e usarli oppure combattere a mani nude al fine di mandare l'avversario fuori dalla piattaforma o dall'area di gioco.

### Funzionalità minime ritenute obbligatorie:

- [x] Movimento 2D
- [x] Gestione delle hitbox
- [x] Comandi di attacco, schivata
- [x] Oggetti random che cadono dall'alto in un posto randomico della mappa
- [x] Gestione la piattaforma e le aree di morte
- [x] Almeno 2 armi e 2 powerup
- [x] Gestione del dannometro

### Funzionalità opzionali:

- [ ] Più armi e powerup
- [ ] Aggiunta degli oggetti lanciabili
- [ ] Più mappe di gioco
- [ ] Più modalità: ad esempio una a vite, una a tempo ecc
- [ ] Attacchi speciali
- [ ] Aggiungere un Bot

### Suddivisione del lavoro:

- Carfì:
  - Gestione del movimento 2D e delle hitbox
  - Mosse e gestione di comandi
- Grassetti:
  - Fisica, scenario di gioco e aree di morte
  - Gestione caduta oggetti
- Collorà:
  - Interfaccia di gioco e gestione statistiche
  - Gestione powerup
  - Dannometro

### Guida utente

Il gioco si aprirà con la schermata iniziale. Una volta premuto il tasto **START**, si aprirà la schermata di personalizzazione del personaggio:

- è possibile assegnare 7 punti in tutto per ogni giocatore
- ogni statistica non può avere più di 10 punti.
  Una volta assegnati tutti i punti, premere il tasto **FINE** e cominciate a picchiarvi.

- _Tasti_:
  - **Player One**:
    - W: salto
    - A: muovi a sinistra
    - S: muovi a destra
    - G: attacca
    - H: schiva
  - **Player Two**:
    - UP: salto
    - LEFT: muovi a sinistra
    - RIGHT: muovi a destra
    - NUMPAD2: attacca
    - NUMPAD3: schiva
