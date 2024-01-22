package org.jingyes.designpattern.Creational.property;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈敬
 * @date 2024/1/22
 */
public class Charactor implements Prototype {
    private final Map<EnumStatType, Integer> properties = new HashMap<>();
    private final Prototype prototype;

    private String name;

    private EnumStatType statType;

    public Charactor() {
        this.prototype = new Prototype() {
            @Override
            public void set(EnumStatType statType, Integer value) {

            }

            @Override
            public Integer get(EnumStatType statType) {
                return null;
            }

            @Override
            public boolean has(EnumStatType statType) {
                return false;
            }

            @Override
            public void remove(EnumStatType statType) {

            }
        };
    }

    public Charactor(Charactor prototype, String name) {
        this.prototype = prototype;
        this.statType=prototype.getStatType();
        this.name = name;
    }

    public Charactor(Prototype prototype, EnumStatType statType) {
        this.prototype = prototype;
        this.statType = statType;
    }

    @Override
    public void set(EnumStatType statType, Integer value) {
        this.properties.put(statType, value);
    }

    @Override
    public Integer get(EnumStatType statType) {
        if (this.properties.containsKey(statType)) {
            return properties.get(statType);
        }
        return this.prototype.get(statType);
    }

    @Override
    public boolean has(EnumStatType statType) {
        return get(statType) != null;
    }

    @Override
    public void remove(EnumStatType statType) {
        this.properties.put(statType, null);
    }

    public EnumStatType getStatType() {
        return statType;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        if (name != null) {
            builder.append("instance name:").append(name).append('\n');
        }

        if (statType != null) {
            builder.append("stat type= ").append(statType.name()).append('\n');
        }

        builder.append("items:\n");
        for (var stat : EnumStatType.values()) {
            var value = this.get(stat);
            if (value == null) {
                continue;
            }
            builder.append(" - ").append(stat.name()).append(':').append(value).append('\n');
        }
        return builder.toString();
    }
}
