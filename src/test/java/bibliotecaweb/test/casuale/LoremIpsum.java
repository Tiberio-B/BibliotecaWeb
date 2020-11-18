package bibliotecaweb.test.casuale;

public interface LoremIpsum {

	public static final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

	public static final String[] NOMI = { "Abramo", "Acantha", "Ace", "Achille", "Ada", "Adamo",
			"Adelaide", "Adele", "Adimar", "Adina", "Adolfo", "Adorno", "Adriana", "Adriano",
			"Adriel", "Adriele", "Afra", "Agar", "Agata", "Agave", "Agnese", "Agostino", "Aimeu'",
			"Alan", "Alarico", "Alba", "Albano", "Alberta", "Alberto", "Albino", "Alcina", "Alda",
			"Aldo", "Aldobrando", "Aldwin", "Alea", "Aleramo", "Alessandra", "Alessandro",
			"Alessia", "Alessio", "Alfio", "Alfonsina", "Alfonso", "Alfredo", "Alhena", "Alia",
			"Alice", "Alida", "Alina", "Allegra", "Alma", "Altair", "Altea", "Alvaro", "Alvina",
			"Amalia", "Amanda", "Amaranta", "Amarilli", "Ambra", "Ambrogio", "Amedeo", "Amina",
			"Amos", "Anastasia", "Ancilla", "Andrea", "Andreina", "Andromeda", "Angela", "Angelica",
			"Angelo", "Annika", "Anna", "Annunziata", "Anselmo", "Antonia", "Antonio", "Aquilante",
			"Arabella", "Aramis", "Arduino", "Aretha", "Argelia", "Aria", "Arianna", "Ariele",
			"Ariella", "Aristide", "Arlena", "Armando", "Armida", "Arnaldo", "Aroldo", "Liburo",
			"Ashton", "Aspasia", "Assunta", "Asteria", "Athos", "Attilio", "Audrey", "Augusta",
			"Augusto", "Aura", "Aurea", "Aurelio", "Aurora", "Axel", "Azalea", "Azzurra", "Baldo",
			"Baldovino", "Balthazar", "Barbara", "Bardo", "Bartolomeo", "Battista", "Beatrice",
			"Belinda", "Bella", "Ben", "Benedetto", "Beniamino", "Benvenuto", "Bernardo", "Berta",
			"Bertrando", "Beryl", "Bianca", "Bibiana", "Bjorn", "Boris", "Brad", "Brent", "Brian",
			"Brigida", "Bruna", "Brunilde", "Bruno", "Bud", "Caio", "Calogero", "Calypso",
			"Camelia", "Cameron", "Camilla", "Camillo", "Candida", "Candido", "Carina", "Carla",
			"Carlo", "Carmela", "Carmelo", "Carolina", "Cassandra", "Auterina", "Cecilia", "Cedric",
			"Celesta", "Celeste", "Cesara", "Cesare", "Chandra", "Chantal", "Chiara", "Cino",
			"Cinzia", "Cirillo", "Ciro", "Claudia", "Claudio", "Clelia", "Clemente", "Clio",
			"Clizia", "Cloe", "Clorinda", "Clotilde", "Concetta", "Consolata", "Contessa", "Cora",
			"Cordelia", "Corinna", "Cornelia", "Corrado", "Cosetta", "Cosimo", "Costantino",
			"Costanza", "Costanzo", "Cristal", "Cristiana", "Cristiano", "Cristina", "Cristoforo",
			"Cruz", "Curzio", "Dafne", "Dagmar", "Dagon", "Daisy", "Dalia", "Dalila", "Damaris",
			"Damiano", "Danae", "Daniela", "Daniele", "Dante", "Daria", "Dario", "Davide", "Dean",
			"Debora", "Dela", "Delfino", "Delia", "Delizia", "Demetrio", "Demos", "Dermont",
			"Desdemona", "Deva", "Diamante", "Diana", "Diego", "Diletta", "Dina", "Dino", "Dionigi",
			"Diva", "Dolcina", "Dolores", "Domenica", "Domenico", "Domitilla", "Donald", "Donar",
			"Donata", "Donato", "Donna", "Dora", "Doriana", "Doriano", "Doris", "Dorotea",
			"Douglas", "Drago", "Drusiana", "Duccio", "Duilio", "Duncan", "Dylan", "Ebe", "Eco",
			"Edda", "Edelweiss", "Eden", "Edera", "Edgardo", "Edith", "Ediardo", "Edvige", "Edwin",
			"Efraim", "Egeria", "Egidio", "Eglantina", "Egle", "Einar", "Elda", "Eldora", "Elena",
			"Eleonora", "Eletta", "Elettra", "Elfo", "Elga", "Elia", "Eliana", "Eligio", "Elio",
			"Elisabetta", "Elissa", "Ella", "Elsa", "Elvino", "Elvio", "Elvira", "Elvis",
			"Emanuela", "Emanuele", "Emilia", "Emiliana", "Emiliano", "Emilio", "Emma", "Enea",
			"Enki", "Ennio", "Enrica", "Enrico", "Enza", "Enzo", "Eolo", "Era", "Erasmo", "Erica",
			"Eris", "Ermanno", "Ermes", "Erminio", "Ernesto", "Eros", "Esmeralda", "Ester", "Ethel",
			"Etilla", "Ettore", "Eudora", "Eugenia", "Eugenio", "Euridice", "Euro", "Eva", "Evania",
			"Evelina", "Ezio", "Fabiana", "Fabiano", "Fabio", "Fabrizia", "Fabrizio", "Faith",
			"Falco", "Fara", "Fatima", "Fausta", "Fausto", "Febo", "Fedele", "Federica", "Federico",
			"Fedra", "Felice", "Feliciano", "Felicita", "Fenella", "Ferdinando", "Fergal", "Fergus",
			"Fermo", "Fernanda", "Fernando", "Ferruccio", "Fiammetta", "Filiberto", "Filippo",
			"Fillide", "Filomena", "Fiona", "Fiore", "Fiorella", "Fiorenza", "Fiorenzo", "Flaminia",
			"Flaminio", "Flavia", "Flavio", "Flora", "Floriano", "Folco", "Ford", "Fortuna",
			"Fortunato", "Franca", "Francesca", "Francesco", "Franco", "Freya", "Frida", "Frine",
			"Fulvia", "Fulvio", "Furio", "Gabriele", "Gabriella", "Gaetano", "Gaia", "Gail",
			"Galtea", "Galeazzo", "Gardenia", "Gareth", "Gaspare", "Gastone", "Gavin", "Gaynor",
			"Gea", "Gelsomina", "Geltrude", "Gemma", "Gennaro", "Genoveffa", "Genziana", "Gerardo",
			"Gerda", "Germano", "Ghino", "Giacomo", "Giada", "Gigliola", "Gilberto", "Gilda",
			"Ginestra", "Ginevra", "Gioia", "Giole", "Giona", "Giordano", "Giorgio", "Giotto",
			"Giovanna", "Giovanni", "Gisella", "Giuditta", "Giulia", "Giuliana", "Giuliano",
			"Giulio", "Giunia", "Giuseppe", "Giuseppina", "Glauco", "Glen", "Glenda", "Glicera",
			"Gloria", "Godiva", "Goffredo", "Goliard", "Gordon", "Graham", "Grant", "Grazia",
			"Graziana", "Graziano", "Gregorio", "Griselda", "Gualtiero", "Guendalina", "Guerrino",
			"Guglielmo", "Guicciardo", "Guido", "Gunnar", "Gurthie", "Gustavo", "Haidar", "Haila",
			"Harrison", "Hassan", "Haydee", "Heather", "Hela", "Hidalgo", "Hiram", "Holger",
			"Hoshi", "Hasib", "Ida", "Idalia", "Igea", "Ignazio", "Igor", "Ilaria", "Ilario",
			"Ilda", "Ilia", "Ilva", "Imera", "Immacolata", "Indro", "Inga", "Ingmar", "Ingrid",
			"Iolanda", "Iole", "Iorio", "Ippolita", "Ippolito", "Irene", "Iris", "Iride", "Irma",
			"Irvin", "Isabella", "Isaura", "Isidoro", "Isotta", "Italo", "Ivan", "Ivana", "Ivano",
			"Ivilla", "Ivo", "Izusa", "Jader", "Jael", "Jafar", "Jamil", "Janez", "Jaron",
			"Jasmine", "Jason", "Jemina", "Jessica", "Jin", "Jocelyn", "Joel", "Joelle", "Jonathan",
			"Kamar", "Keith", "Ken", "Kendra", "Kilian", "Kim", "Kira", "Kirk", "Lada", "Ladislao",
			"Lamberto", "Lancelot", "Lanfranco", "Lara", "Laura", "Lavinia", "Lea", "Leandro",
			"Leda", "Lee", "Leila", "Leo", "Leon", "Leonardo", "Leone", "Leonida", "Leopoldo",
			"Leslie", "Letizia", "Levi", "Levia", "Lia", "Liala", "Liana", "Licia", "Lidia",
			"Liliana", "Lilith", "Lilka", "Linda", "Linnea", "Lino", "Linus", "Liu'", "Liuba",
			"Livia", "Livio", "Lonella", "Lora", "Loredana", "Loreley", "Lorena", "Lorenza",
			"Lorenzo", "Lothar", "Luana", "Luca", "Luce", "Lucia", "Luciana", "Luciano", "Lucio",
			"Lucrezia", "Ludmilla", "Ludovica", "Ludovico", "Luigi", "Luigia", "Luminosa", "Luna",
			"Lupo", "Lynn", "Mabel", "Macha", "Maddalena", "Madonna", "Mafalda", "Magnolia",
			"Mahina", "Maia", "Mainard", "Malcom", "Malik", "Malka", "Malvina", "Mammola",
			"Mandisa", "Manfredo", "Manlio", "Mara", "Marcella", "Marcello", "Marco", "Margherita",
			"Maria", "Marianna", "Nariano", "Marica", "Marilena", "Marilyn", "Marina", "Marino",
			"Mario", "Marlon", "Marlow", "Marta", "Martina", "Martino", "Marvin", "Marzia",
			"Marzio", "Massimiliano", "Massimo", "Matilde", "Matteo", "Mattia", "Maude", "Maura",
			"Maurizia", "Maurizio", "Mauro", "Medardo", "Medea", "Medusa", "Megan", "Melania",
			"Melantha", "Melba", "Melia", "Melinda", "Melissa", "Melody", "Melvin", "Mercedes",
			"Meredith", "Michela", "Michele", "Mildred", "Milena", "Milo", "Milton", "Milva",
			"Mimosa", "Mintha", "Miranda", "Mirina", "Mirinna", "Mirko", "Mirra", "Mirta", "Mizar",
			"Moanna", "Modesto", "Moira", "Momo", "Monica", "Morana", "Morena", "Moreno", "Morgan",
			"Morgana", "Mughetta", "Muriel", "Musa", "Nadia", "Naomi", "Nara", "Narilla", "Nasya",
			"Natale", "Natalia", "Nathaniel", "Nausicaa", "Nazario", "Neda", "Nella", "Nelson",
			"Nem", "Nereo", "Nerina", "Nicola", "Nicoletta", "Ninfa", "Nissa", "Nives", "Noa",
			"Noemi", "Nolan", "Nora", "Norberto", "Norma", "Norman", "Novella", "Nuriel", "Odell",
			"Odessa", "Odilia", "Ofelia", "Olaf", "Olga", "Oliana", "Olimpia", "Olisa", "Oliva",
			"Oliviero", "Omar", "Ombretta", "Ondina", "Onella", "Opal", "Orazio", "Orchidea",
			"Oreste", "Oriana", "Orio", "Orion", "Orlando", "Orlena", "Ornella", "Orso", "Orsola",
			"Ortensia", "Oscar", "Ossian", "Osvaldo", "Ottavia", "Ottaviano", "Ottavio", "Otto",
			"Ottone", "Owen", "Palma", "Palmira", "Paloma", "Pamela", "Pandia", "Pandora", "Paola",
			"Paolo", "Paralda", "Paride", "Pasquale", "Patrizia", "Patrizio", "Penelope",
			"Perceval", "Perla", "Perseo", "Pervinca", "Petronilla", "Petunia", "Pia", "Pico",
			"Piera", "Pietro", "Pio", "Pirro", "Pisana", "Polissena", "Porthos", "Porzia",
			"Preziosa", "Primavera", "Primo", "Primula", "Prisca", "Prisco", "Publio", "Querida",
			"Quincy", "Quintiliano", "Quinto", "Quinzio", "Quirino", "Rachele", "Raffaele",
			"Raffaella", "Rahda", "Raimonda", "Raimondo", "Reagan", "Rebecca", "Reed", "Regina",
			"Remigio", "Remo", "Renata", "Renato", "Rex", "Rhea", "Rhoda", "Rhys", "Riccarda",
			"Riccardo", "Rihanna", "Rinaldo", "Rita", "Roberta", "Roberto", "Robin", "Rocco",
			"Rodolfo", "Rodrigo", "Rohana", "Rok", "Rolf", "Romana", "Romano", "Romeo", "Romilda",
			"Romina", "Romolo", "Rooney", "Rosa", "Rosalia", "Rosalinda", "Rosaria", "Rosario",
			"Rosaura", "Ross", "Rossana", "Rossella", "Roswita", "Rowena", "Ruben", "Rubina",
			"Ruggero", "Ruth", "Ryan", "Sabra", "Sabrina", "Sada", "Sadir", "Sakura", "Salomu'",
			"Salomone", "Salvatore", "Samantha", "Samuele", "Santina", "Santino", "Sara", "Sarad",
			"Satinka", "Saul", "Saverio", "Savino", "Scilla", "Scott", "Sean", "Sebastiano",
			"Selene", "Selma", "Selvaggia", "Sem", "Sennen", "Senta", "Serafina", "Serafino",
			"Serena", "Sergio ", "Severo", "Shada", "Shaina", "Shanti", "Sharar", "Sharon",
			"Shaula", "Sheena", "Sheila", "Shirah", "Shirley", "Sibilla", "Sidney", "Sigfrido",
			"Sigmund", "Silvana", "Silvano", "Silvestro", "Silvia", "Simeone", "Simona", "Simone",
			"Sina", "Sirena", "Siro", "Sivio", "Skip", "Smeralda", "Sofia", "Solana", "Solange",
			"Soledad", "Sonia", "Spartaco", "Speranza", "Stanislao", "Stefania", "Stefano",
			"Stelio", "Stella", "Sulayman", "Sunna", "Susanna", "Sven", "Svetlana", "Taffy",
			"Takara", "Talia", "Talitha", "Tamara", "Tancredi", "Tara", "Taras", "Tarcisio",
			"Tatiana", "Tazio", "Tea", "Telga", "Teo", "Teodora", "Teodoro", "Terenzio", "Teresa",
			"Teseo", "Tessa", "Thelma", "Thera", "Tia", "Tiffany", "Timoteo", "Titania", "Tito",
			"Tiziana", "Tiziano", "Tobia", "Tommaso", "Tosca", "Tristano", "Tullia", "Tullio",
			"Tyler", "Tyron", "Tyson", "Ubaldo", "Uberto", "Ugo", "Ulderico", "Uliana", "Ulisse",
			"Ulla", "Umberta", "Umberto", "Urania", "Uriel", "Ursula", "Valentina", "Valentino",
			"Valeria", "Valerio", "Vanessa", "Vasco", "Vassjli", "Vedia", "Vega", "Velania",
			"Velia", "Vera", "Verbena", "Verena", "Verilla", "Veronica", "Vesta", "Vida", "Videmar",
			"Vincenza", "Vincenzo", "Viola", "Virgilio", "Virginia", "Virginio", "Viridiana",
			"Vissia", "Vito", "Vittore", "Vittoria", "Vittorio", "Viviana", "Vladimiro", "Wala",
			"Waldo", "Wally", "Wanda", "Werner", "Werther", "Wilson", "Wolfgang", "Wolfram",
			"Xantha", "Xenia", "Ximena", "Xena", "Yama", "Yarin", "Yasu", "Ymer", "Ymir", "Yuma",
			"Yuri", "Yvonne", "Yumi", "Zada", "Zahara", "Zaira", "Zak", "Zarah", "Zelia", "Zelig",
			"Zenaide", "Zeno", "Zilla", "Zita", "Zoe", "Zorya", "Zuleika", "Zelda" };

	public static final String[] COGNOMI = { "Abbondanza", "Abu", "Accadia", "Acquafredda",
			"Acquafondata", "Acunzo", "Adorno", "Agostini", "Aguila", "Ahamed", "Ahmed El Ghandor",
			"Aiello", "Alam", "Albanese", "Albanese", "Alfano", "Alpi", "Amato", "Amato",
			"Andronico", "Andruccioli", "Angelicchio", "Angiuli", "Anklin", "Antonelli",
			"Antonelli", "Antosh", "Apa", "Apreda", "Arena", "Arlati", "Armaroli", "Assal",
			"Attendoli", "Avello", "Avendato", "Azzarri", "Bagnaia", "Bagnato", "Baiano", "Baldari",
			"Baldi", "Baldinotti", "Balice", "Balloni", "Balta", "Baragliu", "Barbieri", "Bardi",
			"Barone", "Barone", "Baronti", "Barruga", "Barsanti", "Bartolini", "Bartolucci",
			"Basile", "Basile", "Bassani", "Bassano", "Bassolino", "Battaglia", "Battelli",
			"Bazhanova", "Bazzocchi", "Bellaneve", "Bellettini", "Bellini", "Bellino", "Bellinzoni",
			"Bello", "Bencivenga", "Benedetti", "Benhadda", "Bennada Epse Herichi", "Bentivegna",
			"Bento Da Silva", "Berardi", "Bernacci", "Bernardi", "Bernardini", "Bertini",
			"Bevilacqua", "Bianchi", "Bianchi", "Bianco", "Biondini", "Blasi", "Blasi ", "Boes",
			"Boncompagni", "Bonn", "Bonomo", "Bonsignore", "Bonventre", "Borgat-wohlbang",
			"Borghini", "Borkowska", "Borrelli", "Boschi", "Botnariu", "Boubaker", "Bragioto",
			"Brambilla", "Brizi", "Brunetti", "Bruni", "Bruni", "Bruno", "Buccolieri", "Bugli",
			"Buongrazio", "Burla", "Bushulli", "Caccamo", "Cagnotti", "Calabrese", "Caldironi",
			"Caligari", "Caligiuri", "Callegarini", "Campana", "Campanella", "Cangini",
			"Canichella", "Caniglia ", "Cannizzaro", "Capanna", "Capelli", "Capitani", "Capone ",
			"Caporilli", "Caputo", "Caraballo", "Carbone", "Cardinetti", "Carina", "Carpi Marasco",
			"Carrara", "Carucci", "Carullo", "Caruso", "Casadei", "Casali", "Casella", "Castagna",
			"Castagnoli", "Castaldi", "Castaldo", "Castelli", "Autalano", "Autaldi", "Auttaneo",
			"Cauteruccio", "Cavallo", "Cavaterra", "Ceccarelli", "Ceccaroni", "Cecchetti", "Cecere",
			"Cellini", "Celotti", "Cenciarelli", "Ceraldi", "Cerchierini", "Cerilli", "Chaibi",
			"Charaf", "Cheikh Talibouya", "Chesti", "Chiricozzi", "Ciampaglia", "Ciarla",
			"Ciarlariello", "Cicconi", "Cichon", "Ciervo", "Cipollone", "Cirillo", "Clementucci",
			"Clesceri", "Coccia", "Colle", "Colli", "Colombo", "Colombo ", "Colongi", "Colonna",
			"Coluccia", "Coluccio", "Comini", "Conflitti", "Conte", "Conte", "Conti", "Contiu",
			"Coppola", "Corrado", "Corraretti", "Corrias", "Cospito", "Costa", "Costa",
			"Costantini", "Costantini", "Coulier", "Covato", "Cozzolino", "Crepaldi", "Croce",
			"Crognale", "Curcio", "Cusin", "Cutillo", "D'Achille", "D'Agapito", "D'Alessandro",
			"Dallago", "D'Ambrosio", "D'Amico", "D'Amora", "D'Amore", "De Angelis", "De Bacco",
			"De Autaldo", "De Domenico ", "De Filippis", "De Florio", "De Freitas Sousa Tavares",
			"De La Cruz", "De Luca", "De Matteo", "De Peppe", "De Rosa", "De Santis", "De Santis",
			"De Simone", "De Stefano", "De Sterlich", "Deiana", "Del Aguila Rosario",
			"Delgadillo Vargas", "Delgado", "D'emilia", "Di Benimeo", "Di Carlo", "Di Lena",
			"Di Maio", "Di Marco", "Di Mario", "Di Menna", "Di Paolo", "Di Pasquale", "Di Renna",
			"Di Ruzza", "Di Santo", "Di Sipio", "Di Stefano", "Di Tuoro ", "Diacetti", "Diamantini",
			"Disabato", "Dolciotti", "Domenicali", "Donatantonio", "Donati", "Donati", "Donatini",
			"Donnhauser", "Dorascenzi", "D'ottavio ", "Dotti", "Ducci", "Eichenberger", "El Falaki",
			"El Hallaf", "El Haqaoui", "El Kaaba  Armit", "Emili", "Emumwen", "Ercolani", "Ermeti",
			"Errahmani", "Errichetti", "Esposito", "Esposito", "Fabbri", "Fabbrizi", "Fabiani",
			"Fadda", "Farazi", "Farina", "Fasano", "Fassbender", "Fazi", "Felici", "Ferrante",
			"Ferrara", "Ferrarese", "Ferrari", "Ferrari", "Ferraro", "Ferrero", "Ferretti", "Ferri",
			"Ferro", "Fiadone ", "Fico", "Filagna", "Filipek", "Filippelli", "Filippi", "Finiti",
			"Fiordigigli", "Fiore", "Fiumi", "Fiuzzi", "Focaccia", "Fontana", "Fontana",
			"Fontanella", "Fontanilla", "Fontolan", "Forcina", "Forcina ", "Fortini", "Fossaroli",
			"Fralassi", "Franco", "Frasca", "Fraticelli", "Fratini", "Freschi ", "Fumagalli",
			"Fusco", "Fusini", "Gagliardi", "Galli", "Galli", "Gallo", "Galotti", "Gamberini",
			"Gargiulo", "Garofalo", "Gasmi", "Gatti", "Gatti", "Gealapu", "Gentile", "Gentili",
			"Gentilini", "Ghazi", "Ghini", "Giannetti", "Gigante", "Gindre", "Giordano",
			"Giorgetti", "Giorgi", "Giorgio", "Giuliani", "Giuliani", "Giura", "Giurgola", "Gnani",
			"Gori", "Graffiedi", "Grande", "Grassi", "Grasso", "Grebenea", "Greco", "Grimaldi",
			"Gromala", "Grossi Pavia", "Guaman", "Gubinelli", "Guerra", "Guida", "Guidi", "Guidi",
			"Guillen Crespo", "Gutjahr", "Guzman Soriano", "Haji", "Hajji", "Harasymiuk", "Harroud",
			"Haryadi", "Hijjoui", "Hossain", "Huaman Lopez", "Hushchyna", "Iachini", "Iacoangeli",
			"Iacobelli", "Ianne", "Iatalese", "Infante", "Iuliano", "Jagmin", "Jaschke ", "Jebrane",
			"Jianu", "Kamal", "Karim", "Kazi", "Kellmann", "Kosek", "Kovacs", "La Bella",
			"La Sorda", "Labella", "Lacerenza", "Laita", "Lanconelli", "Lanzoni", "Latini",
			"Lattanzi", "Laurenti", "Lazar", "Lazazzera", "Lecca", "Lelli", "Lena", "Leone",
			"Leonetti", "Lesniewska", "Liberto ", "Linzi", "Lippi", "Lombardi", "Lombardo", "Longo",
			"Lopez", "Lorusso", "Lucani", "Lucarini", "Lucchesini", "Lucchi", "Lunerti", "Luzietti",
			"Luzzi", "Magalotti", "Mahu", "Malagigi", "Maldini", "Mamone", "Manchia", "Mancini",
			"Mane", "Mane'", "Mangano", "Manzi", "Marano", "Marata", "Marchesini", "Marchetti",
			"Marchi", "Marchi", "Mariani", "Mariani", "Marini", "Marino", "Marocchini",
			"Maroncelli", "Marra", "Martellini ", "Martinelli", "Martini", "Martino", "Martino",
			"Martys", "Mascali Zeo", "Masetti", "Massa", "Mathlouthi", "Mattioni", "Mauro", "Mazza",
			"Medda", "Mele", "Meloni", "Mena", "Mercantini", "Messina", "Metozzi", "Meucci",
			"Mezzogori", "Michilli", "Milani", "Milenov", "Milutinovic", "Mincuzzi", "Minelli",
			"Minestrini ", "Minnella", "Minuz", "Mirante", "Mohammed", "Moiano", "Mollica",
			"Monaco", "Monsone ", "Monsorno", "Montanari", "Montevecchi", "Monti", "Montuori",
			"Morelli", "Moretti", "Moro", "Morselli", "Morsiani", "Moschetti", "Moukrim", "Mucci",
			"Mugione", "Muratori", "Mussinelli", "Naci", "Napoli", "Napolitano", "Narducci", "Neri",
			"Niane", "Nicastro", "Nini", "Nizzi", "Nurul", "Nuti", "Odigwe", "Oliva", "Olivelli",
			"Olivieri", "Orlandi", "Orlando", "Ortu", "Ossati", "Pace", "Pacini", "Paduano",
			"Pagano", "Paglia", "Pal Ionut", "Palatano", "Palazzari", "Palma ", "Palmieri",
			"Palumbo", "Panchetti", "Panichi", "Panza", "Paolini", "Papaleo", "Paradisi", "Parini",
			"Parisi", "Parravani", "Pascale", "Pascucci", "Pasolini", "Pasquini", "Passitto",
			"Pastore", "Patruno", "Patwary", "Paul", "Pellegrini", "Pellegrino", "Pelliccia",
			"Pello'", "Pelo", "Pepe", "Pereira De Castro", "Perrone", "Petritoli", "Pezzuco", "Pia",
			"Piacentini", "Piani", "Piazza", "Piccoli", "Piccolo", "Piersanti", "Pierucci",
			"Pierucci ", "Piga", "Pinna", "Pinna", "Piras", "Piro", "Pisacane", "Placidi ",
			"Planta", "Poli", "Policarpo", "Polidori", "Polyzopoulos", "Pompili", "Pongetti",
			"Poni", "Popescu", "Popovici", "Porcu", "Porta", "Potalivo ", "Pozzi", "Pozzi",
			"Pracucci", "Prelati", "Proietti", "Pucciotti", "Pulsoni", "Quadalti Noferini",
			"Quadrini", "Quartarone", "Rainesi", "Ranfi", "Ranucci", "Raqabi", "Rebeccato",
			"Renzoni", "Renzulli", "Resende Azevedo", "Riboloni", "Ricci", "Ricci", "Ricciardi",
			"Ricciolino", "Rifilato", "Rimoldi", "Rinaldi", "Riva", "Rizzelli", "Rizzi", "Rizzo",
			"Robbio", "Rocchi", "Romagnoli ", "Romani Bergonzo", "Romano", "Romano", "Romeo",
			"Rosata", "Rosati", "Rosato", "Rossetti", "Rossi", "Rossi", "Rotella", "Rucci", "Rudel",
			"Ruggeri", "Ruggieri", "Ruggiero", "Russo", "Russo", "Saccone", "Sala", "Sala",
			"Salamone ", "Salvemini", "Salvini", "Sanges", "Sanna", "Sanna", "Santana Moscato",
			"Santini", "Santoro", "Santucci", "Sarpieri", "Sartori", "Sartori", "Sassetti", "Sassi",
			"Sasvari", "Satta", "Sbreni", "Scarale", "Scardone", "Scipioni", "Scotti", "Sebastiani",
			"Sementilli", "Sepe ", "Serban", "Seri", "Serra", "Sestito", "Settembrini", "Severi",
			"Sgrigna", "Siapian", "Silvestri", "Simonetti", "Simoni", "Sipio", "Siracusa",
			"Soldati", "Sorbalo", "Sorgentone", "Soro", "Sorrentino", "Sorrentino", "Spalletta",
			"Speziale", "Spoletini", "Sposato", "Stazzone", "Stefanovich", "Steffanina",
			"Steffenoni", "Stefoni", "Strazzanti", "Succi", "Tabane", "Taifi", "Tambini", "Tarani",
			"Tarnogrodzki", "Tarozzi", "Taurone", "Tazzari", "Teodorani", "Terracciano", "Testa",
			"Tiglio", "Tioni", "Tiranno", "Tisba", "Toader", "Tomassi", "Torraca", "Toso",
			"Tosolini", "Totaro ", "Tranquilli", "Trasforini", "Trombino", "Tronconi", "Tufano",
			"Tulli", "Turci", "Urbini", "Urzo", "Usami", "Vaccaro", "Valbonesi", "Valdinosi",
			"Valente", "Valentini", "Valvano", "Vandenbulcke", "Vanni", "Vannozzi", "Vassura",
			"Vella", "Veneziani", "Veneziano", "Verastegui Pereyra", "Vidanalage", "Villa", "Villa",
			"Villani", "Vincenzi", "Vinciguerra", "Vitale", "Vitali", "Vitor", "Volpe", "Von Oppen",
			"Wally", "Wenz", "Wicher", "Williams", "Wilmer", "Wirth", "Wozniak", "Wozniczka",
			"Zaccaria", "Zak", "Zamberlan", "Zandoli", "Zanella", "Zanellati", "Zanelli", "Zanetti",
			"Zapalski", "Zaratti", "Zavalloni", "Zavoli", "Zecchini", "Zenina", "Zeolla", "Zepponi",
			"Zinnamosca", "Zito", "Zivkovic", "Zolea", "Zolnowski", "Zuccherelli", "Zurzolo" };

	public static final String[] GENERI = { "STORICO", "FANTASCIENZA", "FANTASY", "AVVENTURA",
			"FORMAZIONE", "RAGAZZI", "HORROR", "GIALLO_NOIR_THRILLER", "ROSA", "EROTICO",
			"PSICOLOGICO", "UMORISTICO", "SOCIALE", "EPISTOLARE", "FIABA_FAVOLA", "STORIOGRAFIA",
			"BIOGRAFIA", "DIARIO", "DIVULGATIVO", "ORATORIA", "POESIA", "EPICA", "TEATRO",
			"OPERA_MUSICAL" };

	public static final String[] LOCALI = { "Osteria", "Ristorante", "Pizzeria", "Trattoria",
			"Enoteca", "Agriturismo", "Locanda", "Rosticceria", "Tavola Calda", "Pub" };

	public static final String[] DUG = { "Accesso", "Allea", "Alinea", "Alzaia", "Androna",
			"Angiporto", "Arco", "Archivolto", "Arena", "Argine", "Bacino", "Baluardo", "Banchi",
			"Banchina", "Barbarìa", "Bastione", "Bastioni", "Belvedere", "Bivio", "Borgata",
			"Borgo", "Borgoloco", "Cal", "Calata", "Calle", "Calle Larga", "Calle Lunga",
			"Calle Stretta", "Callesèlla", "Callesèllo", "Callétta", "Campiello", "Campo", "Canale",
			"Cantone", "Capo Di Piazza", "Carraia", "Carrara", "Carrarone", "Carro", "Cascina",
			"Case Sparse", "Cavalcavia", "Cavone", "Chiasso", "Chiassetto", "Chiassuola",
			"Circonvallazione", "Circumvallazione", "Claustro", "Clivio", "Clivo", "Complanare",
			"Contrà", "Contrada", "Corsetto", "Corsia", "Corso", "Corte", "Cortesela", "Corticella",
			"Cortile", "Cortile Privato", "Costa", "Crocicchio", "Crosa", "Cupa", "Cupa Vicinale",
			"Diramazione", "Discesa", "Distacco", "Emiciclo", "Erta", "Estramurale", "Fondaco",
			"Fondamenta", "Fondo", "Fossa", "Fossato", "Frazione", "Galleria", "Gradinata",
			"Gradini", "Gradoni", "Granviale", "Isola", "Larghetto", "Largo", "Laterale", "Lido",
			"Lista", "Litoranea", "Località", "Lungadige", "Lungarno", "Lungo", "Lungoadda",
			"Lungoargine", "Lungobisagno", "Lungo Brenta", "Lungobusento", "Lungocalore",
			"Lungo Castellano", "Lungocrati", "Lungocanale", "Lungocurone", "Lungodora",
			"Lungofiume", "Lungofoglia", "Lungofrigido", "Lungogesso", "Lungoisarco", "Lungoisonzo",
			"Lungolago", "Lungolario", "Lungolinea", "Lungoliri", "Lungomare", "Lungomazaro",
			"Lungomolo", "Lungonera", "Lungoparco", "Lungo Po", "Lungoporto", "Lungosabato",
			"Lungosile", "Lungostura", "Lungotalvera", "Lungotanaro", "Lungotevere", "Lungoticino",
			"Lungotorrente", "Lungotronto", "Lungovelino", "Masseria", "Merceria", "Molo", "Mura",
			"Murazzi Del Po", "Parallela", "Passaggio", "Passaggio Privato", "Passeggiata",
			"Passeggio", "Passo", "Passo Di Piazza", "Pendice", "Pendino", "Pendio", "Penninata",
			"Piaggia", "Piazza", "Piazza", "Piazza", "Piazza", "Piazza", "Piazza", "Piazza",
			"Piazza Inferiore", "Piazza Privata", "Piazzale", "Piazzetta", "Piazzetta Privata",
			"Piscina", "Ponte", "Portico", "Porto", "Prato", "Prolungamento", "Quadrato", "Raggio",
			"Ramo", "Rampa", "Rampa Privata", "Rampari", "Rampe", "Ratto", "Recinto", "Regione",
			"Rettifilo", "Regaste", "Riello", "Rione", "Rio", "Rio Terà", "Ripa", "Riva", "Riviera",
			"Rondò", "Rotonda", "Rua", "Ruga", "Rugheta", "Sacca", "Sagrato", "Saia", "Salita",
			"Salita Inferiore", "Salita Superiore", "Salizada", "Scalea", "Scalette", "Scalinata",
			"Scalone", "Scesa", "Sdrucciolo", "Selciato", "Sentiero", "Slargo", "Sopportico",
			"Sotoportego", "Sottoportico", "Spalto", "Spiaggia", "Spianata", "Spiazzo", "Strada",
			"Strada Accorciatoia", "Strada Alzaia", "Strada Antica", "Strada Arginale",
			"Strada Bassa", "Strada Cantoniera", "Strada Carrareccia", "Strada Consolare",
			"Strada Consortile", "Strada Consorziale", "Strada Di Bonifica", "Strada Esterna",
			"Strada Inferiore", "Strada Intercomunale", "Strada Interna", "Strada Interpoderale",
			"Strada Litoranea", "Strada Militare", "Strada Nazionale", "Strada Panoramica",
			"Strada Pedonale", "Strada Perimetrale", "Strada Poderale", "Strada Privata",
			"Strada Provinciale", "Strada Regionale", "Strada Rotabile", "Strada Rurale",
			"Strada Traversante", "Strada Vicinale", "Stradale", "Stradella", "Stradello",
			"Stradetta", "Stradone", "Stradoncello", "Stretta", "Stretto", "Strettoia", "Strettola",
			"Svoto", "Supportico", "Terrazza", "Tondo", "Traversa", "Traversa Privata",
			"Traversale", "Trasversale", "Tratturo", "Trazzera", "Tresanda", "Tronco", "Vanella",
			"Vallone", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via",
			"Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via", "Via",
			"Via Accorciatoia", "Via Al Mare", "Via Alta", "Via Alzaia", "Via Antica",
			"Via Arginale", "Via Bassa", "Via Circolare", "Via Comunale", "Via Consolare",
			"Via Cupa", "Via Destra", "Via Erta", "Via Estramurale", "Via Inferiore",
			"Via Intercomunale", "Via Interna", "Via Laterale", "Via Lungomare", "Via Militare",
			"Via Nazionale", "Via Nuova", "Via Pedonale", "Via Privata", "Via Provinciale",
			"Via Regionale", "Via Rotabile", "Via Rurale", "Via Sinistra", "Via Stretta",
			"Via Superiore", "Via Trasversale", "Via Vecchia", "Via Vicinale", "Vial", "Viale",
			"Viale Lungomare", "Viale Privato", "Vialetto", "Vialone", "Vicinale", "Vicoletto",
			"Vicoletto Cieco", "Vicolo", "Vicolo Chiuso", "Vicolo Cieco", "Vico",
			"Vico Estramurale", "Vico Inferiore", "Vico Lungo", "Vico Nuovo", "Vico Privato",
			"Vico Rotto", "Vico Storto", "Vico Stretto", "Vico Superiore", "Viella", "Vietta",
			"Villaggio", "Viottolo", "Viuzza", "Viuzzo", "Vocabolo", "Volti", "Voltone" };

	public static final String[] NUMERI_ROMANI = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
			"IX", "X" };

	public static final String[] MENU = { "Menu' Bambini", "Menu' Vegetariano", "Menu' Vegano",
			"Menu' per Celiaci", "Menu' Famiglia", "Menu' di Carne", "Menu' di Pesce",
			"Menu' di Pasqua", "Menu' di Pasquetta", "Menu' di Ferragosto", "Menu' di Natale",
			"Menu' di Capodanno", "Menu' Gourmet", "Menu' Premium", "Menu' dello Chef",
			"Menu' Tradizionale", "Menu' della Tradizione", "Menu' della Casa", "Menu' del Giorno",
			"Menu' Casereccio", "McMenu'", "Menu' Convenienza", "Menu' Extra Large" };

	public static final String[] CATEGORIE_ECOMMERCE = { "Bellezza", "Salute", "Animali", "Casa",
			"Cucina", "Sport", "Tempo Libero", "Prima infanzia", "Cancelleria", "Fai da te",
			"Elettronica", "Giardinaggio", "Informatica", "Auto e Moto", "Abbigliamento", "Giochi",
			"Illuminazione", "Scarpe", "Borse", "Valigeria", "Gioielli", "Strumenti musicali",
			"Videogiochi", "Elettrodomestici", "Libri", "Orologi", "Idee Regalo",
			"Prodotti Alimentari", "Software", "Hardware", "Film e TV", "Giocattoli", "Bambini",
			"Prodotti per Ufficio", "CD e Vinili" };

	public static final String[] FAKE_WORDS = { "Papapay", "Cockshed", "Pitioning", "Terithrow",
			"Subgrated", "Allouncer", "Cended", "Payellards", "Moderock", "Autermich",
			"Stardestrious", "Irrublor", "Ricouncitant", "Impencured", "Thrubbish", "Dizoolexa",
			"Compto", "Talocajoling", "Tribution", "Gyshile", "Bashanks", "Miralitt",
			"Evenchically", "Eaterfully", "Jobfusticate", "Hygienevangelist", "Racted", "Brigate",
			"Muskely", "Preppanting", "Opcong", "Wetwest", "Ivortion", "Paratered", "Uliratha",
			"Ovistshing", "Joristic", "Grob", "Steredects", "Gioppler", "Stally", "Replitz",
			"Corrower", "Eminste", "Matumbia", "Oleald", "Maxteep", "Branizericing", "Gebreakank",
			"Flaudient", "Delistemanally", "Senhamperking", "Cleviationly", "Parapentors",
			"Firehorse", "Litated", "Obstans", "Eminste", "Recinators", "Azzimpler", "Ezocholon",
			"Mahardston", "Cliple", "Autermich", "Huzlip", "Trates", "Reveforly", "Infusidicienes",
			"Vacarestracian", "Grapdrow", "Attelling", "Parkasting", "Imartankhang", "Republast",
			"Veytoy", "Beaspieching", "Blonneymon", "Enfinizatics", "Hattitude", "Ratica",
			"Eklimmsel", "Utionsons", "Sastery", "Satinge", "Peloozoid", "Mentrition", "Nalpure",
			"Corrot", "Sagending", "Sedubing", "Monikorasort", "Hioffpo", "Finatitaing", "Vabling",
			"Milateramilt", "Variskys", "Hughte", "Nekmit", "Moducilwoops", "Cippert", "Redully",
			"Fuppeto", "Whipletener", "Houshia", "Boilest", "Drywest", "Syricouch", "Prologisang",
			"Incircers", "Oppoons", "Reachrigy", "Cikliption", "Vansion", "Ropouts",
			"Regalawsuisted", "Lochich", "Animepolis", "Pullmaplic", "Occlon", "Happliest",
			"Roshankleboal", "Logingindecars", "Cleoniclosel", "Mingstrity", "Overudes",
			"Inefulnessalle", "Weisatted", "Fruismyther", "Delistemanally", "Ettiquartz", "Donsul",
			"Cippert", "Hysleria", "Impenelly", "Inusintering", "Untypistown", "Choorlish",
			"Numentursofaus", "Obsenators", "Breater", "Cusing", "Subtrattagons", "Crucate",
			"Noelind", "Matigulating", "Sneablathes", "Posistorather", "Expets", "Roinad",
			"Queudoted", "Novanoid", "Nekmit", "Yeinydd", "Hysleria", "Hooppler", "Dropperclear",
			"Esuyp", "Nanoarrow", "Qiameth", "Alerrawia", "Pulappli", "Wetchop", "Frorealm",
			"Vacso", "Arrowgance", "Shiphile", "Gogogox", "Siopp", "Bestfloor", "Gogopo",
			"Busyglide", "Spourmo", "Yodacloud", "Fluffster", "Ociramma", "Skizzle", "Sevit",
			"Defas", "Looplab", "Doggax", "Qerrassa", "Nalpure", "Shorogyt", "Zestpond", "Naperone",
			"Noxu", "Hexteria", "Eggmode", "Chucknology", "Bistup", "Sinpad", "Reiltas",
			"Steeplump", "Kizerain", "Spusious", "Lotadilo", "Swooflia", "Bronea", "Hawkloon",
			"Kiraric", "Parede", "Besloor", "Wavefire", "Glomtom", "Aferraron", "Tupacase",
			"Didiza", "Chershoee", "Onama", "Biasdo", "Boxscape", "Seiliu", "Chorenn", "Wetwest",
			"Novaly", "Werradith", "Hoppler", "Eraow", "Acaer", "Yoffa", "Jeren", "Tupress",
			"Animepolis", "Noelind", "Ekcle", "Hendassa", "Glaretram", "Winooze", "Surogou",
			"Brewtine", "Chillaid", "Rodrup", "Toximble", "Morath", "Nocobot", "Digikiki", "Oleald",
			"Yimello", "Voquev", "Resaix", "Peachflame", "Yboiveth", "Toogit", "Novanoid", "Nekmit",
			"Yeinydd", "Hysleria", "Hooppler", "Luezoid", "Chesture", "Feandra", "Boaclick",
			"Yammoe", "Mofoblitz", "Xanpon", "Singlewave", "Roplixoo", "Losenoid", "Loodon",
			"Rowlow", "Claster", "Pepelexa", "Sertave", "Dropellet", "Jeebus", "Noodile",
			"Drearien", "Kaloolon", "Norrisology", "Ybuwyn", "Fuffapster", "Jobox", "Creabird",
			"Astauand", "Mizuxe", "Slabdrill", "Zestybus", "Ferirama", "Tuttadit", "Printure",
			"Geosyog", "Plakill", "Bioyino", "Waratel", "Sexatoo", "Moderock", "Replitz", "Pegmode",
			"Mizule", "Lazap" };

	public static final String[] CVCVCVCV = { "Orizefe", "Ubusepu", "Ifaguva", "Ozigefo", "Omutifa",
			"Afumudu", "Enepube", "Opanume", "Azodafi", "Ovepapu", "Ulomezu", "Asuvuce", "Agunemi",
			"Efurozu", "Emoveru", "Icebeti", "Isafupo", "Elacebo", "Agomasa", "Ogubisi", "Acecata",
			"Ebupone", "Omuvuco", "Odenezi", "Acotaru", "Ezamopi", "Agovanu", "Ofafuba", "Enebaga",
			"Irurora", "Avevami", "Amamuco", "Osoposu", "Adolufe", "Erofano", "Ifupeso", "Ecomuvi",
			"Azupupa", "Efivide", "Idefese", "Ilafesa", "Izimume", "Ezupuso", "Amerize", "Adocego",
			"Agavasi", "Ulamevu", "Isepeva", "Upepedi", "Unonavo", "Esumilu", "Avesote", "Esufegu",
			"Ogepabi", "Erufelo", "Usatede", "Onalora", "Afitaso", "Ebipibe", "Ovivubi", "Acimoso",
			"Imerona", "Ezogafi", "Ivezise", "Itufemu", "Avedofu", "Aciliro", "Amibeba", "Arevodo",
			"Efuficu", "Ifeveva", "Ofonavi", "Edapucu", "Omenepu", "Igasano", "Itupamu", "Avezodi",
			"Afifada", "Uzogeze", "Emuponu", "Unineru", "Elotule", "Alarumu", "Emelezu", "Epenefa",
			"Amogoca", "Ucuzoce", "Abomodo", "Emobela", "Edusure", "Odidoda", "Omupulo", "Udiriti",
			"Opesocu", "Ezedele", "Ufibemo", "Ucuviga", "Ugadevi", "Onuboco", "Utilelo", "Ezasugi",
			"Amipibu", "Aburedi", "Olicosu", "Obetimi", "Uburufo", "Utobotu", "Evanavu", "Agozevu",
			"Evimizu", "Izirube", "Inafamo", "Igovoce", "Otigove", "Idilepa", "Icezubo", "Urozulu",
			"Abunoge", "Acunofa", "Enifode", "Apamete", "Umevidi", "Ifunugo", "Ilulilu", "Alucudu",
			"Uculero", "Esamelu", "Anavuro", "Olemaza", "Itimelu", "Ezecebo", "Ozabida", "Avusofa",
			"Ozarevu", "Avisefe", "Enesibo", "Esogube", "Analuda", "Ocemedu", "Amisovu", "Uforizo",
			"Ulalafo", "Ucumime", "Ugodolo", "Osoturi", "Ivomame", "Osobabo", "Iponage", "Ozevofo",
			"Olomenu", "Egovepo", "Evozoco", "Umesigo", "Ovelebo", "Udaporu", "Efusuzo", "Imurogi",
			"Ovoleba", "Onerabo", "Ovebetu", "Ubucobu", "Idesagi", "Eperesa", "Igarozu", "Obusopu",
			"Uvuloza", "Ocetovu", "Anusice", "Osacipo", "Itafudo", "Ocadire", "Onetiba", "Ametote",
			"Atutotu", "Ivipure", "Azevumu", "Umacuni", "Osiduce", "Azetiro", "Imepalu", "Itodeca",
			"Atitori", "Upocibe", "Onobipu", "Acadute", "Uladuve", "Ulifona", "Agisunu", "Iripide",
			"Etemata", "Uvusana", "Abafoso", "Abolofo", "Isumave", "Ifidozu", "Eruvuci", "Odulune",
			"Iposule", "Ibogucu", "Obavefe", "Ononuri", "Izafiga", "Afefiro", "Iremufu", "Apigetu",
			"Umugizo", "Unafide", "Ivufebi", "Enoveli", "Erofitu", "Utimami", "Esifapa", "Atalezu",
			"Osatiro", "Ivepuzu", "Avovilo", "Ezuveru", "Iramati", "Alizaca", "Osilimu", "Onuboni",
			"Osalomu", "Emosaca", "Omufuge", "Izabogo", "Ubovuto", "Ubezuzi", "Ozufalo", "Azefupo",
			"Obogove", "Amesega", "Elacega", "Elaciga", "Edinini", "Orumulo", "Osezunu", "Uguvopi",
			"Umunazu", "Obicobo", "Amunuco", "Ifanozo", "Umodecu", "Alevili", "Erumubi", "Ugecopo",
			"Ebusago", "Useguvo", "Uviriri", "Uluzeba", "Unomape", "Imuzila", "Irunuma", "Onapazu",
			"Eticadi", "Icocavu", "Imavogi", "Elotupo", "Atoneda", "Ofegalu", "Elazati", "Asucere",
			"Ozagapa", "Imuvise", "Inotifi", "Ogetize", "Igutida", "Odotape", "Otucepo", "Erudupe",
			"Epoletu", "Utesite", "Etapivo", "Ovilufe", "Abusazo", "Ovazivo", "Azovelo", "Avozeze",
			"Irosabo", "Ofisuru", "Ocipuda", "Apilazo", "Itafevo", "Ezuvimi", "Umadavo", "Ovafiba",
			"Edovove", "Aducule", "Ucapuco", "Idanevo", "Afobivo", "Ugitecu", "Ogecono", "Ofogonu",
			"Evutara", "Ebegize", "Enalari", "Icapuvu", "Asemape", "Erimaru", "Uzudoca", "Avedido",
			"Ipelevu", "Urufasu", "Ipetoba", "Analoze", "Umefeto", "Ibedafa", "Elenomu", "Agumaba",
			"Anapile", "Edinuca", "Ovividi", "Otivede", "Olivuru", "Ecaruri", "Anunogi", "Usofife",
			"Izemuro", "Ozatopi", "Agemuro", "Ifedise", "Uzubuva", "Ususalu", "Olevevi", "Etobiva",
			"Urapabi", "Itinafi", "Ufumopo", "Odibiza", "Orufufu", "Utabudi", "Icipori", "Oguleco",
			"Izebifi", "Atevogo", "Icavuge", "Apagagu", "Umebuni", "Anolaci", "Agogoda", "Osilobe",
			"Egafodu", "Upobeno", "Ifudonu", "Emuluzo", "Igovoza", "Ifinodi", "Otubera", "Iziguva",
			"Ucedovu", "Igocugu", "Ilazito", "Icabaro", "Otobalu", "Ilotube", "Ofitano", "Onoramo",
			"Uvamido", "Epofari", "Orabunu", "Emubuso", "Avazule", "Efezimu", "Urisumi", "Esinodo",
			"Agelalo", "Ivubebo", "Odisuta", "Alovage", "Uloboce", "Ecobose", "Umegefo", "Ogeluco",
			"Onezico", "Ipotobe" };

	public static final String[] ANTIPASTI = { "Tagliere", "Formaggi", "Salumi", "Bruschette",
			"Crudi", "Crostini", "Pizzette", "Frittelli", "Panzerotti", "Polpette", "Spiedini",
			"Focaccelle", "Alici", "Focaccine", "Crocchette", "Suppl�", "Panzerotti" };

	public static final String[] PRIMI = { "Spaghetti", "Rigatoni", "Penne", "Pennette", "Bucatini",
			"Linguine", "Trofie", "Mafalde", "Zuppa" };

	public static final String[] SECONDI = { "Tagliata", "Fiorentina", "Bistecca", "Sgombro",
			"Filetto", "Costolette", "Razza", "Fritti", "Coniglio", "Anatra", "Burger", "Tartare",
			"Agnello", "Cotolette", "Coda", "Polpo", "Ricciola", "Merluzzo", "Polpettone",
			"Pasticcio", "Arista" };

	public static final String[] CONTORNI = { "Verdure", "Zucchine", "Patate", "Patatine", "Chips",
			"Insalata", "Melanzane", "Spinaci", "Verza", "Carciofi", "Broccoli", "Cavolini" };

	public static final String[] DOLCI = { "Torta", "Tiramis�", "Panna Cotta", "Gelato", "Sorbetto",
			"Crostata", "Tortino", "Brownies", "Dolcetti", "Macedonia", "Crema", "Cheesecake",
			"Profiterol", "Semifreddo", "Ciambelle", "Roselline", "Chiacchiere", "Frappe",
			"Biscotti", "Biscottini", "Biscotto", "Bab�", "Zuccotto", "Castagnole", "Panettone",
			"Pandoro", "Ciambellone", "Ciambelline" };
}