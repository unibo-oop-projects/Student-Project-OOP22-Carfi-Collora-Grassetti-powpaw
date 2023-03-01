Il gruppo si pone l'obiettivo di creare un **Platform Fighting Game** in stile *Super Smash Bros* o *Brawlhalla*. Lo scopo del gioco è battere il tuo avversario in una battaglia `1 vs 1`.

#### Requisiti funzionali
- Prima del combattimento si avrà la possibilità di personalizzare le statistiche del proprio personaggio giocabile; nello specifico il personaggio avrà dei *punti statistica* di base e dei *punti statistica aggiuntivi* da potere sommare a quest'ultime a proprio piacimento.
- Durante la battaglia, cadranno *oggetti* dall'alto e ogni giocatore potrà raccoglierli e usarli oppure combattere a mani nude al fine di mandare l'avversario fuori dalla piattaforma o dall'area di gioco.

#### Requisiti non funzionali
- Utilizzo del **Builder Pattern** per la personalizzazione del personaggio.
- Utilizzo dell'**Observer Pattern** per la gestione del campo di gioco.
- Utilizzo dello **State Pattern** per gestire gli stati di gioco.
- Utilizzo del **Component Pattern** per la gestione delle armi.

#### Analisi e modello del dominio
I personaggi dovranno essere creati prima dell'inizio di ogni partita. Una volta creati, dovranno essere in grado di muoversi sulla piattaforma con un movimento 2D che gli possa permettere un movimento a destra e a sinistra, di salvare e schivare. Ogni Player sarà in grado di colpire l'avversario e di raccogliere e utilizzare le armi e i powerup caduti dall'alto fino a che uno dei due Player verrà sconfitto.
Arrecare danno all'avversario farà aumentare sua la percentuale di _dannometro_ (percentuale di danno subito). Piu' la percentuale è alta, rischio di finire fuori dall'area di gioco sarà maggiore. 

Gli aspetti più impegnativi sono la gestione del movimento e delle collisioni tra i personaggi, le armi e gli oggetti di gioco. In particolare, è necessario assicurarsi che i personaggi si muovano fluidamente sulla piattaforma, interagiscano correttamente con gli oggetti di gioco e rispondano correttamente ai comandi dei giocatori.
![[EntityDiagram.jpg]]