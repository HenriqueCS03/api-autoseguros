package br.com.fiap.seguroautomotivo.models;

public record Token(
    String token,
    String type,
    String prefix
) {}