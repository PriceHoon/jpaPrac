package jpa.pricehoon.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimeStamp is a Querydsl query type for TimeStamp
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QTimeStamp extends EntityPathBase<TimeStamp> {

    private static final long serialVersionUID = -66926427L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimeStamp timeStamp = new QTimeStamp("timeStamp");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final jpa.pricehoon.user.QUser createdBy;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final jpa.pricehoon.user.QUser modifiedBy;

    public QTimeStamp(String variable) {
        this(TimeStamp.class, forVariable(variable), INITS);
    }

    public QTimeStamp(Path<? extends TimeStamp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimeStamp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimeStamp(PathMetadata metadata, PathInits inits) {
        this(TimeStamp.class, metadata, inits);
    }

    public QTimeStamp(Class<? extends TimeStamp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new jpa.pricehoon.user.QUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.modifiedBy = inits.isInitialized("modifiedBy") ? new jpa.pricehoon.user.QUser(forProperty("modifiedBy"), inits.get("modifiedBy")) : null;
    }

}

