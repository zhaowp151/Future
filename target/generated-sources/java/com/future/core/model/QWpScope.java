package com.future.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWpScope is a Querydsl query type for WpScope
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWpScope extends EntityPathBase<WpScope> {

    private static final long serialVersionUID = -465731355L;

    public static final QWpScope wpScope = new QWpScope("wpScope");

    public final StringPath code = createString("code");

    public final StringPath flg = createString("flg");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QWpScope(String variable) {
        super(WpScope.class, forVariable(variable));
    }

    public QWpScope(Path<? extends WpScope> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWpScope(PathMetadata metadata) {
        super(WpScope.class, metadata);
    }

}

