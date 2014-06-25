package liquibase.statement.core;

import liquibase.statement.AbstractStatement;
import liquibase.structure.DatabaseObject;
import liquibase.structure.core.Table;
import liquibase.structure.core.UniqueConstraint;
import liquibase.util.StringUtils;

public class AddUniqueConstraintStatement extends AbstractStatement {

    private String catalogName;
    private String schemaName;
    private String tableName;
    private String columnNames;
    private String constraintName;
    private String tablespace;

    private boolean deferrable;
    private boolean initiallyDeferred;
    private boolean disabled;

    public AddUniqueConstraintStatement(String catalogName, String schemaName, String tableName, String columnNames, String constraintName) {
        this.catalogName = catalogName;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.constraintName = constraintName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnNames() {
        return columnNames;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public String getTablespace() {
        return tablespace;
    }

    public AddUniqueConstraintStatement setTablespace(String tablespace) {
        this.tablespace = tablespace;
        return this;
    }

    public boolean isDeferrable() {
        return deferrable;
    }

    public AddUniqueConstraintStatement setDeferrable(boolean deferrable) {
        this.deferrable = deferrable;
        return this;
    }

    public boolean isInitiallyDeferred() {
        return initiallyDeferred;
    }

    public AddUniqueConstraintStatement setInitiallyDeferred(boolean initiallyDeferred) {
        this.initiallyDeferred = initiallyDeferred;
        return this;
    }

    public AddUniqueConstraintStatement setDisabled(boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @Override
    protected DatabaseObject[] getBaseAffectedDatabaseObjects() {
        UniqueConstraint uniqueConstraint = new UniqueConstraint()
                .setName(getConstraintName())
                .setTable((Table) new Table().setName(getTableName()).setSchema(getCatalogName(), getSchemaName()));
        int i = 0;
        for (String column : StringUtils.splitAndTrim(getColumnNames(), ",")) {
            uniqueConstraint.addColumn(i++, column);
        }

        return new DatabaseObject[]{
                uniqueConstraint
        };
    }
}
