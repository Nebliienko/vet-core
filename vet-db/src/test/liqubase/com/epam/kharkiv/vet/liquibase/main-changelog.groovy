databaseChangeLog {
    
    property(file: 'com/epam/kharkiv/vet/liquibase/database.properties')

        changeSet(id: '2014-10-20-00', author: 'Maksym Nebliienko <Maksym_Nebliienko@epam.com>') {
            comment('Create schema')
            sql('CREATE SCHEMA ${dbSchema}')
            rollback{
                sql('DROP SCHEMA ${db.schema}')
            }
        }

    changeSet(id: '2014-10-20-01', author: 'Maksym Nebliienko <Maksym_Nebliienko@epam.com>') {
        comment('Create veterinary table')
        preConditions(onFail:'MARK_RAN', onError:'CONTINUE', onFailMessage: 'Table exists, skipping changeset') {
            not {
                tableExists (schemaName: dbSchema, tableName: 'veterinary')
            }
        }
        createTable(schemaName: dbSchema, tableName: 'veterinary', remarks: 'Stores veterinaries for our clinic. ') {
            column(name: 'id', type: 'varchar(128)', remarks: 'Primary key')
            column(name: 'name', type: 'varchar(30)', remarks: 'Name of the employee')
            column(name: 'surname', type: 'varchar(30)', remarks: 'Surname of the employee')
            column(name: 'age', type: 'int', remarks: 'Age of the employee')
            column(name: 'specialization', type: 'varchar(20)', remarks: 'Specialization of the employee')
        }
        addNotNullConstraint(schemaName: dbSchema, tableName: 'veterinary', columnName: 'id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'veterinary', columnName: 'name', columnDataType: 'varchar(30)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'veterinary', columnName: 'surname', columnDataType: 'varchar(30)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'veterinary', columnName: 'age', columnDataType: 'int')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'veterinary', columnName: 'specialization', columnDataType: 'varchar(20)')
        addPrimaryKey(schemaName: dbSchema,
        tableName: 'veterinary',
        columnNames:'id',
        constraintName:'PK_VETERINARY')
        rollback{
            dropTable(schemaName: dbSchema, tableName: 'veterinary')
        }
    }


    changeSet(id: '2014-10-20-02', author: 'Maksym Nebliienko <Maksym_Nebliienko@epam.com>') {
        comment('Create pet_owner table')
        preConditions(onFail:'MARK_RAN', onError:'CONTINUE', onFailMessage: 'Table exists, skipping changeset') {
            not {
                tableExists (schemaName: dbSchema, tableName: 'pet_owner')
            }
        }
        createTable(schemaName: dbSchema, tableName: 'pet_owner', remarks: 'Stores visitors of our clinic. ') {
            column(name: 'id', type: 'varchar(128)', remarks: 'Primary key')
            column(name: 'name', type: 'varchar(30)', remarks: 'Name of the visitor')
            column(name: 'surname', type: 'varchar(30)', remarks: 'Surname of the visitor')
            column(name: 'age', type: 'int', remarks: 'Age of the visitor')
            column(name: 'email', type: 'varchar(128)', remarks: 'Email of the visitor')
        }
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet_owner', columnName: 'id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet_owner', columnName: 'name', columnDataType: 'varchar(30)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet_owner', columnName: 'surname', columnDataType: 'varchar(30)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet_owner', columnName: 'age', columnDataType: 'int')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet_owner', columnName: 'email', columnDataType: 'varchar(128)')
        addPrimaryKey(schemaName: dbSchema,
        tableName: 'pet_owner',
        columnNames:'id',
        constraintName:'PK_PET_OWNER')
        rollback{
            dropTable(schemaName: dbSchema, tableName: 'pet_owner')
        }
    }

    changeSet(id: '2014-10-20-03', author: 'Maksym Nebliienko <Maksym_Nebliienko@epam.com>') {
        comment('Create pet table')
        preConditions(onFail:'MARK_RAN', onError:'CONTINUE', onFailMessage: 'Table exists, skipping changeset') {
            not {
                tableExists (schemaName: dbSchema, tableName: 'pet')
            }
        }
        createTable(schemaName: dbSchema, tableName: 'pet', remarks: 'Stores our clinic visitor`s pets. ') {
            column(name: 'id', type: 'varchar(128)', remarks: 'Primary key')
            column(name: 'moniker', type: 'varchar(30)', remarks: 'Pet`s moniker')
            column(name: 'owner_id', type: 'varchar(128)', remarks: 'Pet`s owner')
            column(name: 'age', type: 'int', remarks: 'Pet`s age')
            column(name: 'species', type: 'varchar(30)', remarks: 'Pet`s species')
        }
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet', columnName: 'id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet', columnName: 'moniker', columnDataType: 'varchar(30)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet', columnName: 'owner_id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet', columnName: 'age', columnDataType: 'int')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'pet', columnName: 'species', columnDataType: 'varchar(30)')
        addPrimaryKey(schemaName: dbSchema,
        tableName: 'pet',
        columnNames:'id',
        constraintName:'PK_PET')
        addForeignKeyConstraint(constraintName:'FK_OWNER_ID_TO_PET',
        baseTableSchemaName: dbSchema,
        baseTableName:'pet',
        baseColumnNames:'owner_id',
        referencedTableSchemaName: dbSchema,
        referencedTableName:'pet_owner',
        referencedColumnNames:'id')
        rollback{
            dropTable(schemaName: dbSchema, tableName: 'pet')
        }
    }

    changeSet(id: '2014-10-20-04', author: 'Maksym Nebliienko <Maksym_Nebliienko@epam.com>') {
        comment('Create visit_history table')
        preConditions(onFail:'MARK_RAN', onError:'CONTINUE', onFailMessage: 'Table exists, skipping changeset') {
            not {
                tableExists (schemaName: dbSchema, tableName: 'visit_history')
            }
        }
        createTable(schemaName: dbSchema, tableName: 'visit_history', remarks: 'Stores visit_history of our clinic`s patiens. ') {
            column(name: 'id', type: 'varchar(128)', remarks: 'Primary key')
            column(name: 'veterinary_id', type: 'varchar(128)', remarks: 'Veterinary related to this visit')
            column(name: 'pet_id', type: 'varchar(128)', remarks: 'Pet visited')
            column(name: 'reason', type: 'varchar(128)', remarks: 'Visit reason')
            column(name: 'visit_time', type: 'timestamp', remarks: 'Visit time')
            column(name: 'information', type: 'text', remarks: 'Additional information about visit')
        }
        addNotNullConstraint(schemaName: dbSchema, tableName: 'visit_history', columnName: 'id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'visit_history', columnName: 'veterinary_id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'visit_history', columnName: 'pet_id', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'visit_history', columnName: 'reason', columnDataType: 'varchar(128)')
        addNotNullConstraint(schemaName: dbSchema, tableName: 'visit_history', columnName: 'visit_time', columnDataType: 'timestamp')
        addPrimaryKey(schemaName: dbSchema,
        tableName: 'visit_history',
        columnNames:'id',
        constraintName:'PK_VISIT_HISTORY')
        addForeignKeyConstraint(constraintName:'FK_VETERINARY_ID_TO_VISIT_HISTORY',
        baseTableSchemaName: dbSchema,
        baseTableName:'visit_history',
        baseColumnNames:'veterinary_id',
        referencedTableSchemaName: dbSchema,
        referencedTableName:'veterinary',
        referencedColumnNames:'id')
        addForeignKeyConstraint(constraintName:'FK_PET_ID_TO_VISIT_HISTORY',
        baseTableSchemaName: dbSchema,
        baseTableName:'visit_history',
        baseColumnNames:'pet_id',
        referencedTableSchemaName: dbSchema,
        referencedTableName:'pet',
        referencedColumnNames:'id')
        rollback{
            dropTable(schemaName: dbSchema, tableName: 'visit_history')
        }
    }
}
