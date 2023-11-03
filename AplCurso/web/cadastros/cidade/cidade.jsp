<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Estados</h2>
<div class="col-13 panel-body">
    <table id="datatable" class="table table-striped table-bordered basic-datatable">
        <thead>
            <tr>
                <th align="left">ID</th>
                <th align="left">Cidade</th>
                <th align="left">Estado</th>
                <th align="right"></th>
                <th align="right"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cidade" items="${cidades}" >
                <tr>
                    <td aling="left">${cidade.idCidade}</td>
                    <td align="left">${cidade.nomeCidade}</td>
                    <td align="left">${cidade.estado.siglaEstado}</td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/CidadeExcluir?idCidade=${cidade.idCidade}">
                            <button class="btn btn-danger"
                                    <c:out value="${cidade.situacao == 'A' ? 'btn-danger': 'btn-success'}"/>" >
                                <c:out value="${cidade.situacao == 'A' ? 'Inativar': 'Ativar'}" />
                            </button>    
                        </a>
                    </td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/CidadeCarregar?idCidade=${cidade.idCidade}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        
    </table>
</div>
<div align="center">
    <a href="${pageContext.request.contextPath}/CidadeNovo">Novo</a>
    <a href="index.jsp">Voltar a pagina Inicial</a>
</div>
     <script>
        $(document).ready(function(){
            console.log('entrei ready');
            //caregamos a datatable
            //$("#datatable").DataTable({});
            $('#datatable').DataTable({
                "OLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até_END_de_TOTAL_registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Ultimo"
                    }
                }
            });
        });
    </script>
    
<%@ include file="/footer.jsp" %>


