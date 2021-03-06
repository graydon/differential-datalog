package ddlogapi;

/**
 * Update to an input or output relation.
 *
 * <p>
 * DDlogCommand interface describes an update to a single record of a DDlog
 * relation, which can be one of three kinds (1) insert a new record, (2) delete
 * an existing record specified by value, (3) delete an existing record specified
 * by the record's primary key.
 * </p>
 *
 * <p>
 * This interface is used to represent both updates to DDlog input relations
 * issued by the client and output updates generated by DDlog on transaction commit.
 * </p>
 *
 * <p>
 * The interface is parameterized by record type.  The record type can be either
 * DDlogRecord, used to represent any DDlog datatype in a generic way, or Object,
 * when relation-specific class is used (the caller must then cast the Object to
 * an appropriate class, depending on relation id).
 * </p>
 *
 * <p>
 * TODO: support modify commands.
 * </p>
 */
public interface DDlogCommand<R> {
    enum Kind {
        DeleteVal,
        DeleteKey,
        Insert
    }

    Kind kind();

    /**
     * Relation being modified.
     */
    int relid();

    /**
     * Record or key value.
     */
    R value();
}
