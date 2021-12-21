# a04-a2-template-bioweb-pacients

Plantilla Activitat 04.

L’ICS ens ha demanat la primera fase d’una aplicació web per a gestionar dades bàsiques de pacients de la secció d’oncologia. 
En un futur, voldran crear un portal web amb una intranet on només es podran connectar els usuaris autoritzats. 

Ara per ara, el que els interessa és algunes funcionalitats concretes. 

Necessiten una aplicació web senzilla; amb 3 opcions de menú:
### Estudi de Cadenes d’ADN.
Una pàgina que, donada un tros de cadena d’ADN de com a molt 1000 caràcters, verifiqui si és vàlida i mostri el número de A, G, C i T de l’ADN passat per pantalla. 
Cal informar a l’usuari si no ha inserit una cadena ADN correcta.

### Llistat de pacients.
Una pàgina que mostrarà el tot llistat de pacients en una taula. Cal tenir-ne 4 de inserits inicialment. Ara per ara no posaran filtres a la llista, es mostraran tots.
- OPCIONAL: Mostrar aquesta llista amb un estil RWD, que es vegi bé en totes les pantalles. 

### Afegir pacient.
Una pàgina amb un formulari on l’usuari podrà omplir les dades d’un pacient i guardar-lo al sistema. 
Cal informar a l’usuari si ha pogut registrar el pacient o bé no ha omplert tots els camps correctament. 


## Observacions importants.

Les dades dels pacients, ara per ara, seran:

#### Nom → text
#### Cognoms → text 
#### Genere (home, done, NC) → select o option
#### GrupSanguini→ select o option
#### RH → select o option
#### pes → text, validació número
#### alcada → text, validació número

Les dades en aquesta fase no seran persistents.
Per ara, es guardaran en memòria mitjançant un ArrayList però es preveu que en un futur (el 2022) es gestionin en una base de dades SQL; així que es valorarà positivament usar el patró DAO per a poder fer el canvi d’escenari fàcilment.

## Algunes de les tasques que es preveu implementar en un futur.
    • Login d’usuaris.
    • Que els administradors puguin veure un llistat d’usuaris 
    • Filtrar la llista de clients per alguns criteris: RH, Grup Sanguini...
    • Mostrar la informació dels pacients en un web service.
