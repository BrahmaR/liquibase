package liquibase.statement.core;

import liquibase.statement.AbstractStatement;
import liquibase.structure.DatabaseObject;

public class MetaDataQueryStatement extends AbstractStatement {

    private DatabaseObject example;

    public MetaDataQueryStatement(DatabaseObject example) {
        this.example = example;
    }

    public DatabaseObject getExample() {
        return example;
    }

    @Override
    public String toString() {
        return "Fetch "+example.getClass().getSimpleName()+"(s) like '"+example.toString()+"'";
    }

    @Override
    protected DatabaseObject[] getBaseAffectedDatabaseObjects() {
        return null;
    }
}
