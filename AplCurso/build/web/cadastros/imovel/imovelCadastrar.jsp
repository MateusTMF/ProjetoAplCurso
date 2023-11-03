<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarimovel" action="ImovelCadastrar" method="POST">
    
    <table align="center" border="0">
        
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastros de Imoveis
                </th>
            </tr> 
            <tr>
                <th colspan="2" aling="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="idimovel" id="idimovel" value="${imovel.idImovel}" readonly="readonly"/> </td>
            </tr>
            <tr>
                <td>Descricao: </td>
                <td><input type="text" name="descricao" id="descricao" value="${imovel.descricao}" size="50" maxlength="50" /></td>
            </tr>
            <tr>
                <td>Endereco: </td>
                <td><input type="text" name="endereco" id="endereco" value="${imovel.endereco}" /></td>
            </tr>
             <tr>
                <td>Valor Aluguel: </td>
                <td><input type="text" name="valorAluguel" id="valorAluguel" value="${imovel.valorAluguel}" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" />
                    <input type="reset" name="limpar" id="limpar" value="Limpar" />
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp"> Voltar à Pagina Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>           
<%@ include file="/footer.jsp" %>
