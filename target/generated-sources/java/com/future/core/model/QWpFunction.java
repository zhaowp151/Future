package com.future.core.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWpFunction is a Querydsl query type for WpFunction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWpFunction extends EntityPathBase<WpFunction> {

    private static final long serialVersionUID = 9952167L;

    public static final QWpFunction wpFunction = new QWpFunction("wpFunction");

    public final DatePath<java.util.Date> createTime = createDate("createTime", java.util.Date.class);

    public final StringPath flg = createString("flg");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QWpFunction(String variable) {
        super(WpFunction.class, forVariable(variable));
    }

    public QWpFunction(Path<? extends WpFunction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWpFunction(PathMetadata metadata) {
        super(WpFunction.class, metadata);
    }

}

