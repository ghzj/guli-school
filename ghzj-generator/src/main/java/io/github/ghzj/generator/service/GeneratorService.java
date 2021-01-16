package io.github.ghzj.generator.service;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
public interface GeneratorService {
    byte[] generatorCode(String[] tableNames);
}
