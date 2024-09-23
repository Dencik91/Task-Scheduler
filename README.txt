Aplicație cu Taskuri și cu notificări programate
  Funcționalitatea aplicației noastre constă în a avea un server care gestionează o listă de taskuri și le verifică la intervale regulate de timp. De exemplu: „Amintește-mi ceva peste     500 de secunde”.

Cerință tehnică:
    Creați un server Java care va stoca într-un ArrayList unul sau mai multe taskuri.

    Serverul ar trebui să verifice periodic sarcinile care sunt scadente și să trimită un mesaj de tip log în consola aplicației atunci când timpul de execuție al unui task a fost atins.

    După aceea, serverul trebuie să marcheze taskul ca finalizat.

Instrumente:
    Stocarea taskurilor: Pentru acest proiect, veți folosi un ArrayList.

    Structura Taskului: Taskul va fi o clasă Java și va conține următoarele proprietăți:
        Denumire
        Timpul de execuție
        Statusul - care va fi de tip enum cu două valori: FINALIZAT și PROGRAMAT.

    Docker: Aplicația trebuie să ruleze într-un container Docker, deci va trebui să creați un Dockerfile.

    Teste: Pentru început, ignorați testele.

    Git Commit-uri: Pentru fiecare commit în Git, adăugați la începutul mesajului: [TASK-SCHEDULER -- {mesajul commit-ului vostru}].

Ce veți învăța nou:
    Java Networking & un pic de multithreading
    Containerizare cu Docker
    Extinderea cunoștințelor OOP

Notă finală:
Pregătiți proiectul în așa fel încât să fie posibil de scalat în viitor.