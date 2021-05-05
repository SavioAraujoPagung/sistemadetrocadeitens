package com.colatina.sistemadetrocadeitens.sistemadetrocadeitens.servico;

import com.colatina.sistemadetrocadeitens.sistemadetrocadeitens.dominio.Item;
import com.colatina.sistemadetrocadeitens.sistemadetrocadeitens.repositorio.ItemRepositorio;
import com.colatina.sistemadetrocadeitens.sistemadetrocadeitens.servico.dto.ItemDto;
import com.colatina.sistemadetrocadeitens.sistemadetrocadeitens.servico.exception.RegraNegocioException;
import com.colatina.sistemadetrocadeitens.sistemadetrocadeitens.servico.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServico {

    private final ItemRepositorio itemRepositorio;
    private final ItemMapper itemMapper;

    /*
    public List<ItemDto> listar(){
        return itemRepositorio.listarItem();
    }
    */

    public List<ItemDto> listar(){
        List<Item> itens = itemRepositorio.findAll();
        return itemMapper.toDto(itens);
    }

    public ItemDto obterPorId(Long id){
        Item item = itemRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Item nao encontrado"));
        return itemMapper.toDto(item);
    }

    public ItemDto salvar(ItemDto itemDto){
        Item item = itemMapper.toEntity(itemDto);
        itemRepositorio.save(item);
        return itemMapper.toDto(item);
    }

    public ItemDto alterar(ItemDto itemDto){
        Item item = itemMapper.toEntity(itemDto);
        itemRepositorio.save(item);
        return itemMapper.toDto(item);
    }

    /*
    public UsuarioDto alterar(UsuarioDto usuarioDto){
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuarioSalvo = usuarioRepositorio.findById(usuario.getId()).orElseThrow(() -> new RegraNegocioException("Usuario nao encontrado"));
        usuario.setToken(usuarioSalvo.getToken());
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }
    */

    public void deletar(Long id){
        Item item = itemRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Item nao encontrado"));
        itemRepositorio.delete(item);
    }

}