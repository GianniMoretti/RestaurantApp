![image]("https://github.com/GianniMoretti/RestaurantApp/blob/main/Relazione SWE/Immagini/LogoUnifi.png")

**UNIVERSITA’ DEGLI STUDI DI FIRENZE\
Facolta di Ingegneria\
Corso di Laurea in Ingegneria Informatica**

Motivazione e Descrizione
=========================

Il presente elaborato nasce dall’idea di uno di noi ragazzi che,
lavorando in una pizzeria come cameriere, si è trovato ad interagire con
un applicativo simile. Abbiamo così pensato di riprodurne uno
personalizzato che preveda inoltre, considerato il periodo particolare
che stiamo vivendo, la possibilità di gestire azioni atte alla sicurezza
dei clienti, come il loro monitoraggio per poterli rintracciare.\
L’applicativo ha lo scopo di gestire le varie parti che compongono un
ristorante, in modo da farle interagire e collaborare assieme. Abbiamo
individuato le cinque figure professionali principali che possono
trovarsi ad agire all’interno di un ristorante:

1.  L’organizzatore della sala: è colui che all’arrivo di nuovi clienti
    ha il compito di assegnare loro un tavolo. Ciò può essere realizzato
    utilizzando i tavoli singoli già disposti in sala ad inizio serata o
    aggregandone alcuni se il numero di clienti è elevato. Ha quindi la
    possibilità di contrassegnare come occupati i tavoli assegnati e di
    rimetterli disponibili una volta terminato il servizio e igienizzato
    il tavolo. Inoltre, in vista delle norme di distanziamento imposte
    dal periodo che stiamo vivendo, l’organizzatore della sala può
    decidere se e quali tavoli sono o no utilizzabili.

2.  Il cameriere: ha il compito di gestire i vari servizi ai tavoli,
    ossia di prendere le comande e mandarle alla cucina per la loro
    realizzazione. Le comande sono composte da un insieme di piatti
    presenti nel menù del locale, da dei commenti opzionali sui piatti
    per la cucina e da un insieme di ingredienti aggiunti/rimossi dalle
    varie portate su preferenza e richiesta del cliente. In caso di
    errore di immissione della comanda o di richiesta di modifica da
    parte del cliente, il cameriere può eliminare le portate sbagliate
    in modo da correggere correttamente il conto. Per aprire un servizio
    al tavolo il cameriere è tenuto a prendere un nominativo ed un
    recapito telefonico di uno dei presenti in modo da tenere traccia di
    chi ha frequentato il locale ed essere in grado di rintracciare i
    clienti in caso di necessità.

3.  La cucina: i cuochi ottengono le comande confermate dai camerieri e
    possono spuntarle una volta preparate le pietanze. La cucina si può
    inoltre specializzare in più aree di competenza come, ad esempio, la
    pizzeria e il bar.

4.  Il cassiere: è colui che al termine del servizio a un tavolo esegue
    il conto, contrassegna il tavolo come da pulire ed igienizzare e si
    occupa di memorizzare correttamente i dati dei clienti presenti.

5.  Il gestore del ristorante: è colui che ha accesso ai dati
    memorizzati dei clienti. Può inoltre modificare il menù del locale
    aggiungendo portate e variando gli ingredienti in esse presenti, al
    fine, per esempio, di aggiungere una specialità del giorno.

Possibili aggiunte
------------------

Nonostante non siano state implementate, riportiamo di seguito delle
possibili aggiunte per il nostro applicativo:

-   Ordini a domicilio o da asporto

-   Prenotazioni dei tavoli

-   Login dei vari dipendenti

### Ordini a domicilio o da asporto

L’applicazione potrebbe consentire di effettuare ordini da casa
attraverso un sistema di consegna a domicilio oppure per l’asporto. Gli
ordini verrebbero aggiunti direttamente all’ \`\`OrderManager“ che
provvederebbe a smistarli alle cucine. Al fine di diversificare gli
ordini fatti da casa da quelli presi ai tavoli, emergerebbe la necessità
di un nuovo attributo alla classe \`\`Order” denominato \`\`takeAway".
In base al valore di questo attributo le cucine saprebbero come gestire
gli ordini.

### Prenotazioni dei tavoli

L’organizzatore della sala potrebbe gestire le prenotazioni fatte dai
clienti. Questo è realizzabile attraverso un database contenente le
prenotazioni ricevute. L’orga-\
nizzatore della sala avrebbe la possibilità di scrivere e leggere le
prenotazioni relative ad una certa data al fine di poter organizzare la
sala di conseguenza.

### Login dei vari dipendenti

Al momento del login i dati inseriti verrebbero confrontati con quelli
presenti all’interno di un database. Solo se i dati trovano una
corrispondenza l’applicazione consentirebbe di accedere alla pagina
richiesta. Il manager del ristorante sarebbe in grado di aggiungere e
rimuovere le credenziali dei vari dipendenti a sua discrezione per
regolamentare i ruoli.

Requisiti
=========

Use Case
--------

Dalla descrizione del nostro modello di dominio abbiamo identificato gli
attori in gioco con le varie figure professionali del ristorante e i
rispettivi casi d’uso con le rispettive mansioni. Di seguito viene
riportato l’Use Case Diagram risultante:

![Use Case Diagram]("Immagini/UseCaseDiagram.PNG")

Use Case Template
-----------------

Riportiamo di seguito i template relativi ad alcuni dei pricipali casi
d’uso individuati nel nostro progetto:

![Template che descrive il caso d’uso del cameriere per piazzare un
ordine ad un servizio al tavolo]("Immagini/PlaceOrder.PNG")

![Template che descrive il caso d’uso dell’organizzatore della sala per
creare un tavolo composto]("Immagini/CreateComposedTable.PNG")

![Template che descrive il caso d’uso del cassiere per calcolare il
conto di un servizio al tavolo]("Immagini/GetBill.PNG")

Mockups
-------

Riportiamo di seguito dei possibili mockups relativi alle interfaccie
grafiche della nostra app per l’interazione con i nostri attori.

![Mockup raffigurante un prototipo della home page
dell’app]("Immagini/HomePage.PNG")

![Mockup raffigurante un prototipo della pagina di login del
cameriere]("Immagini/WaiterLogin.PNG")

![Mockup raffigurante un prototipo dell’interfaccia dell’organizzatore
della sala]("Immagini/HallOrganizatorPage.PNG")

![Mockup raffigurante un prototipo dell’interfaccia del cameriere al
momento della creazione di un ordine]("Immagini/OrdineCameriere.PNG")

Progettazione e Implementazione
===============================

Scelte implementative e considerazioni
--------------------------------------

Per implementare il nostro progetto in linguaggio Java ed eseguire i
test ci siamo serviti dell’IDE Eclipse. Al fine di semplificare la
collaborazione abbiamo utilizzato GitHub come stumento di versionamento
del codice. Per quanto riguarda il Class Diagram, l’Use Case Diagram, il
Sequance Diagram e lo schema architetturale in packages ci siamo serviti
del software StarUML.\
Per le competenze richieste dall’elaborato, lo schema da noi riportato e
implementato ha il solo scopo di illustrare le interazioni principali
fra le varie parti, non è quindi atto ad una realizzazione concreta.
L’applicativo si presta, infatti, per essere realizzato ad operare come
un sistema distribuito, prevedendo cioè un server centrale con al suo
interno dati comuni accessibili dai vari terminali attraverso un
protocollo di comunicazione. Ad esempio, l’applicativo in esecuzione sul
tablet del cameriere mostrerebbe l’interfaccia collegata al
WaiterPageController che dialogherebbe con un server tramite delle
classi che permettono tale comunicazione. In questo modo il client
cameriere sarebbe in grado di aggiungere dei \`\`TableService“ al
\`\`TableServiceContainer” che si troverebbe all’interno del server
comune.

Class Diagram
-------------

Qui di seguito riportiamo la realizzazione del Class Diagram che
descrive la nostra logica di dominio in prospettiva di implementazione:

![Class Diagram]("https://github.com/GianniMoretti/RestaurantApp/blob/main/Relazione%20SWE/Immagini/ClassDiagram.png" "fig:") [ClassDiagram]

Classi ed Interfacce
--------------------

Per l’implementazione del nostro applicativo abbiamo sia definito nuove
classi ed interfacce specifiche, sia utilizzato alcune di quelle già
presenti nelle librerie standard di Java.\
Le classi Controller sotto riportate vengono create al momento del login
di un client nella relativa interfaccia grafica, sono una per ciascun
attore e vengono utilizzate nei seguenti modi:

### WaiterPageController

Tramite questo controller, il cameriere può inserire nuovi ordini
relativi ad un determinato tavolo utilizzando il metodo
*placeOrderToTableService()*, oppure creare un nuovo TableService con il
metodo *openTableService()* indicando il tavolo interessato.

![Porzione di codice della classe
WaiterPageController]("Codice/WaiterPageController.PNG")

### HallOraganizatorPageController

È un controller che permette di organizzare i tavoli presenti nella
sala. Al suo interno contiene la lista di tavoli fisici. È possibile
creare nuovi tavoli composti attraverso il metodo
*createComposedTable()* specificando gli id dei tavoli fisici da
utilizzare. Il tavolo composto creato viene direttamente inserito
all’interno del “TableContainer”. *setTablesUnusable()* ci permette
invece di impostare lo stato dei tavoli, specificati con id, nello stato
“Unusable”.

![Porzione di codice della classe
HallOrganizatorPageController]("Codice/HallPage1.PNG")

![Porzione di codice della classe
HallOrganizatorPageController]("Codice/HallPage2.PNG")

### CashierPageController

Questo controller viene utilizzato dall’interfaccia del cassiere per
calcolare il conto relativo ad un servizio al tavolo utilizzando
*getBill()*.

![Porzione di codice della classe
CashierPageController]("Codice/CassierePage.PNG")

### RestaurantManagerPageController

Viene utilizzato per la gestione del “Menù” e dei “TableServiceRecord”
da parte del manager del ristorante. Al suo interno sono presenti metodi
per la gestione del menù, ad esempio *addDish()* e *removeDish()* per
aggiungere e rimuovere un piatto rispettivamente. Inoltre il manager del
ristorante ha la possibilità di cancellare dei “TableServiceRecord”
relativi ad una data con *deleteTableServiceRecords()* o di visionarli
con *getTableServiceRecords()*.

![Porzione di codice della classe
RestaurantManagerPageController]("Codice/ManagerPage.PNG")

### OrderPageController, BarController, KitchenController e PizzeriaController

“OrderPageController” è una classe astratta che abbiamo creato per
definire i metodi necessari ai controller specifici della cucina:
“BarController”, “KitchenController” e “PizzeriaController”. Questi
ultimi, infatti, la implementano e definiscono al loro interno il metodo
astratto *getOrder()* in modo tale da prendere soltanto gli
“OrderRecord” a cui sono interessati. Inoltre “OrderPageController”
implementa l’interfaccia “Observer” del package java.util così da poter
essere avvisata dall’ “OrderManager” (“Observable”) quando vengono
piazzati nuovi ordini e tramite il metodo *update()* aggiornare
automaticamente la lista dei suoi “OrderRecord” (Vedi Sezione Observer
[Observer]).

![Porzione di codice della classe
OrderPageController]("Codice/OrderPage.PNG")

![Porzione di codice della classe
PizzeriaController]("Codice/PizzeriaPage.PNG")

Di seguito riportiamo la descrizione di alcune delle classi principali
appartenenti alla parte di Domain Model del nostro progetto:

### PhisicalTable e ComposedTable

I “PhisicalTable” rappresentano i tavoli presenti all’interno del
locale, vengono identificati tramite un id e *setAvailable()* permette
di renderli utilizzabili o non utilizzabili.

![Porzione di codice della classe
PhisicalTable]("Codice/PhisicalTable.PNG")

“ComposedTable” è un tavolo composto da un insieme di “PhisicalTable” e
viene identificato, anche lui, con un id. Il metodo *addTable()*
permette di aggiungere un “PhisicalTable” al suo interno. Inoltre, è
possibile assegnargli un “TableState” per contrassegnare lo stato in cui
si trova.

![Porzione di codice della classe Composed]("Codice/ComposedTable.PNG")

### TableContainer

Contiene tutti i “ComposedTable” creati dall’organizzatore della sala in
una lista al suo interno. Permette di aggiungere, eliminare o cambiare
lo stato ai tavoli composti con i metodi *addTable()*, *deleteTable(int
id)* e *setComposedTableAvailable()*.

![Porzione di codice della classe
TableContainer]("Codice/TableContainer1.PNG")

![Porzione di codice della classe
TableContainer]("Codice/TableContainer2.PNG")

### TableService

“TableService” è una classe che raggruppa al suo interno tutte le
informazioni inerenti al servizio di un tavolo. Al suo interno troviamo
infatti: lista degli ordini piazzati, “TableServiceRecord”, il
“ComposedTable” a cui è associato e il cameriere che lo ha creato e sta
effettuando il servizio.

![Porzione di codice della classe
TableService]("Codice/TableService.PNG")

### TableServiceContainer

Contiene tutti i “TableService” creati dai camerieri. Permette di
gestire i “TableService” contenuti al suo interno con diversi metodi
come, ad esempio, *addTableService()* per aggiungere un TableService o
*placeOrderToTableService()* per aggiungere un ordine al TableService
del tavolo id.

![Porzione di codice della classe
TableServiceContainer]("Codice/TableServiceContainer.PNG")

### OrderRecord

Questa classe viene utilizzata per inserire i piatti del menù nelle
comande e, inoltre, rende possibile l’aggiunta di un commento o la
rimozione/aggiunta di ingredienti al piatto. All’interno si trovano
infatti due liste di “Ingredients”, una contenente gli ingredienti
aggiunti “ArrayList$<$Ingredient$>$ addedIngredients” e l’altra gli
ingredienti rimossi “ArrayList$<$Ingredient$>$ removedIngredients”.
Attraverso il metodo *getPrice()* calcola il prezzo del piatto
corrispondente sommando e sottraendo il prezzo degli ingredienti
rispettivamente aggiunti e rimossi. Ogni “OrderRecord” è identificato da
un id, lo stesso dell’ “Order” che lo contiene.

![Porzione di codice della classe OrderRecord]("Codice/OrderRecord.PNG")

### OrderManager

Si occupa della gestione degli ordini. Al suo interno è presente una
lista di ordini e con il metodo *addOrder()* se ne possono aggiungere di
nuovi. “OrderManager” estende la classe astratta “Observable” del
package java.util, così che ogni qualvolta venga aggiunto un nuovo
“Order” alla lista venga richiamato *notifyObservers()* che avvisa gli
“Observer” (“OrderPageController”) del nuovo ordine aggiunto (Vedi
Sezione Observer [Observer]).

![Porzione di codice della classe
OrderManager]("Codice/OrderManager.PNG")

### RepositoryMenu e FakeMenuData

“RepositoryMenu” è un’interfaccia che espone tutti i metodi necessari
per la gestione del “Menù” come, ad esempio, *addDish()* e
*removeDish()*. Con *getDishes()* e *getIngredients()* è possibile
ottenere le liste contenenti tutti i piatti e tutti gli ingredienti del
menù. Grazie a questa interfaccia è possibile utilizzare diversi tipi di
oggetti per lo storage di dati senza dover cambiare il codice che
utilizza il menù, introducendo così un ulteriore livello di astrazione.

![Porzione di codice della classe
RepositoryMenu]("Codice/RepositoryMenu.PNG")

“FakeMenuData” implementa “RepositoryMenu” ed è stato creato per avere
un oggetto di storage fittizzio che ci permettesse di eseguire i test
senza dover implementare sul momento piatti e ingredienti.

![Porzione di codice della classe
FakeMenuData]("Codice/FakeMenuData1.PNG")

![Porzione di codice della classe
FakeMenuData]("Codice/FakeMenuData2.PNG")

Design Patterns
---------------

Nella realizzazione del nostro progetto abbiamo ritenuto opportuno
introdurre alcuni design patterns noti, indispensabili alla gestione di
criticità emerse durante il lavoro. I patterns utilizzati nel nostro
applicativo sono:\
\
\
Nella realizzazione del nostro progetto ci siamo imbattuti in delle
situazioni dove è emersa la necessità di introdurre dei design patterns
noti al fine di gestirle in modo agile ed elegante. I patterns
utilizzati nel nostro applicativo sono:\
\
\

All’interno del progetto abbiamo avuto la necessità di introdurre alcuni
design patterns noti per favorire la gestione di alcune dipendenze tra
classi in modo agile ed elegante. I patterns utilizzati sono:

1.  Observer

2.  Singleton

3.  MVC

### Observer {#Observer}

Il pattern comportamentale Observer è utilizzato per instaurare una
relazione uno a molti fra oggetti cosicchè quando un oggetto cambia
stato, tutte le sue dipendenze vengano informate e aggiornate
automaticamente.\
Nella nostra logica di dominio abbiamo avuto la necessità di introdurre
questo pattern per notificare alla cucina l’invio da parte del cameriere
di una nuova comanda. Nonostante siano state deprecate, ci siamo serviti
delle classi “Observable” e “Observer” e dei loro rispettivi metodi
*notifyObservers()* e *update()* forniti dalla libreria java.util.
Abbiamo inoltre deciso di implementare il pattern in modalità push, la
quale prevede che l’oggetto osservato notifichi gli osservatori inviando
direttamente il cambiamento al momento della sua variazione.\
Come è possibile infatti apprezzare dal Class Diagram di Figura
[ClassDiagram], la classe “OrderManager” svolge il ruolo di oggetto
osservato (“Observable”) che notifica l’arrivo di una nuova comanda
inviandola direttamente alla cucina, alla pizzeria e al bar che svolgono
il ruolo di osservatori (“Observer”). Questo avviene attraverso il
metodo *addOrder()* che preso come parametro il nuovo ordine piazzato
dal cameriere lo invia agli “Observers” attraverso il metodo
*notifyObservers()*. Questi ultimi aggiorneranno poi il loro stato
attraverso il metodo *update()* (Vedi Sequence Diagram in Figura
[SequenceDiagram]).

### Singleton

Il pattern Creazionale Singleton è utilizzato per avere un’unica istanza
di una determinata classe.\
Nel nostro progetto abbiamo infatti introdotto questo pattern per
garantire l’unicità delle istanze delle classi “TableContainer”,
“TableServiceContainer” e “OrderManager”, le quali interagiscono con più
attori e classi e si ha quindi la necessità che siano sempre le stesse.
Come è possibile osservare nel Sequence Diagram di Figura
[SequenceDiagram], gli attori non possiedono i riferimenti all’unica
istanza di queste classi, ma li ottengono al momento che necessitano di
utilizzarle attraverso il rispettivo metodo *getInstance()*.

### MVC

Il pattern Architetturale Model-View-Controller è utilizzato quando si
ha la necessità di accedere e modificare dei dati attraverso interazioni
differenti con i client. Per far questo si possono dunque individuare le
tre componenti principali:

-   Model: È la parte che definisce il modello dei dati e le operazioni
    che possono essere eseguite su queste presentandole alla View e al
    Controller. Il Model può inoltre notificare ai vari componenti della
    View eventuali aggiornamenti in seguito a richieste del Controller
    al fine di presentare ai Client dati sempre aggiornati.

-   View: Corrisponde alle varie interfacce dell’applicazione con cui
    gli utenti si possono trovare ad interagire per eseguire delle
    azioni sul sistema.

-   Controller: Svolge il ruolo da mediatore fra il View e il Model,
    trasformando le interazioni dell’utente sul primo in azioni sul
    secondo. Per farlo sfrutta inoltre un meccanismo che prende il nome
    di business logic. Questo consiste nel mettere in vita determinati
    oggetti del Model solo nel momento del loro effettivo bisogno, ossia
    quando devono interagire in risposta alle richieste del client.

Nel nostro applicativo abbiamo sentito la necessità di introdurre questo
pattern in quanto i nostri attori interagiscono fra di loro e con il
sistema al fine di scambiare dati e informazioni attraverso una
molteplicità di viste differenti.\
Riportiamo quindi di seguito l’architettura del nostro applicativo
suddivisa nelle tre componenti sopra descritte:

![Raffigurazione dell’architettura dell’applicativo secondo lo schema
Model-View-Controller]("Immagini/Architecture.PNG")

Disposizione delle classi nei package
-------------------------------------

![Raffigurazione della disposizione delle classi del progetto nei
package]("Immagini/Package.PNG")

UnitTest
========

Per testare la corretta interazione e collabborazione fra le parti
abbiamo realizzato i seguenti test cases per alcune delle classi
principali dell’applicativo:\
Nel progetto è stato utilizzato il framework JUnit 5.0.

WaiterPageControllerTest
------------------------

Nella seguente classe di test, è stata testato il controller del
cameriere. In particolare dopo aver istanziato alcuni tavoli composti,
vengono testate le funzioni *openTableService()* e
*placeOrderToTableService()*. Ciò che ci ha spinto a scegliere questo
test, è stato il fatto questi metodi sono tra i più essenziali tra
quelli che stanno dietro la logica dell’applicativo.

![Porzione di codice del test case del
cameriere]("Codice/TestCameriere.PNG")

RestaurantManagerPageControllerTest
-----------------------------------

Il manager del ristorante può gestire sia i dati relativi ai clienti che
il menù. Nella classe di test sottostante ci siamo concentrati sui
metodi che visualizzano e cancellano i dati dei clienti. Gli altri
metodi relativi al menù non li abbiamo testati per due ragioni
principali: la prima è che non è presente un database sottostante
implementato, la seconda è che sono analoghi ai precedenti.

![Porzione di codice del test case del manager del
ristorante]("Codice/TestManager.PNG")

CashierPageControllerTest
-------------------------

Il controller del cassiere può calcolare il conto associato ad un
servizio al tavolo. Nella classe di test sottostante è stato testato il
corretto funzionamento del metodo *getBill()*. In particolare vengono
istanziati alcuni ordini associati a due diversi servizi al tavolo. Sono
presenti piatti con ingredienti aggiunti e rimossi e ordini di storno.
Quello che il cassiere deve controllare è che vengano calcolati i conti
in modo corretto e che lo stato dei tavoli venga messo a “DA PULIRE”.

![Porzione di codice del test case del
cassiere]("Codice/TestCashier.PNG")

HallOrganizatorPageController
-----------------------------

Nella seguente classe di test, abbiamo testato tutti i metodi principali
del controller dell’organizzatore della sala. In particolare dopo aver
istanziato alcuni tavoli fisici, viene verificato il corretto
funzionamento dei metodi *createComposedTable(), deleteComposedTable(),
setComposedTableAvailable()* e *setTablesUnusable()*. La ragione che ci
ha spinto ad effettuare questi test è, ancora una volta, il fatto che
questi metodi sono tra i più essenziali tra quelli che stanno dietro la
logica dell’applicativo.

![Porzione di codice del test case dell’organizzatore della
sala]("Codice/TestHall1.PNG")

![Porzione di codice del test case dell’organizzatore della
sala]("Codice/TestHall2.PNG")

OrderPageControllerTest
-----------------------

Nella seguente classe di test viene testato il corretto funzionamento
del pattern Observer. In particolare vengono creati due ordini, di cui
uno di storno, che vengono piazzati da un cameriere su un servizio al
tavolo. Il test va a controllare che i controller della cucina, della
pizzeria e del ristorante siano stati aggiornati correttamente.
Successivamente viene piazzato un ulteriore ordine per controllare che i
controller vengano aggiornati nel modo giusto.

![Porzione di codice del test case della cucina]("Codice/TestOrder.PNG")

Sequence Diagram
================

Di seguito riportiamo un possibile scenario di interazione dei nostri
attori:

![Sequence Diagram che documenta il flusso del controllo nel momento in
cui il cameriere piazza un nuovo ordine a un
tavolo]("Immagini/SequenceDiagram.PNG" "fig:") [SequenceDiagram]
