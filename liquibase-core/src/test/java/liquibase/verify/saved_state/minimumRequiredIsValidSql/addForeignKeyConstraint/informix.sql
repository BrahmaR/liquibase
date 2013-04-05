-- Database: informix
-- Change Parameter: baseColumnNames=person_id
-- Database: informix
-- Change Parameter: baseTableName=address
-- Database: informix
-- Change Parameter: constraintName=fk_address_person
-- Database: informix
-- Change Parameter: referencedColumnNames=id
-- Database: informix
-- Change Parameter: referencedTableName=person
ALTER TABLE address ADD CONSTRAINT  FOREIGN KEY (person_id) REFERENCES person (id) CONSTRAINT fk_address_person;