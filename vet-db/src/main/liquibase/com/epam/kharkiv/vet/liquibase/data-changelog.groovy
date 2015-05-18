databaseChangeLog {

    property(file: 'com/epam/kharkiv/vet/liquibase/database.properties')

    changeSet(id: '2014-10-31-00', author: 'Maksym Nebliienko <Maksym_Nebliienko@epam.com>') {
        comment('Data fulfillment')
        sql("INSERT INTO ${dbSchema}.veterinary (id, name, surname, age, specialization) VALUES ('mhorilchanik', 'Maria', 'Horilchanik', 23, 'REPTILE')")
        sql("INSERT INTO ${dbSchema}.veterinary VALUES ('mnebliienko', 'Maksym', 'Nebliienko', 19, 'DOMESTIC')")
        
        sql("INSERT INTO ${dbSchema}.pet_owner VALUES ('mnebliienko', 'Maksym', 'Nebliienko', 19, 'ndfdgfdjg')")
        sql("INSERT INTO ${dbSchema}.pet VALUES ('mypet', 'persik', 'mnebliienko', 2, 'CAT')")
        sql("INSERT INTO ${dbSchema}.visit_history VALUES ('visit1', 'mhorilchanik', 'mypet', 'illness', '2005-10-30', 'Happens')")
    }
}
