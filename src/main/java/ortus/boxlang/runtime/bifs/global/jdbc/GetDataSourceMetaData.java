package ortus.boxlang.runtime.bifs.global.jdbc;
import java.util.Arrays;
import ortus.boxlang.runtime.bifs.BIF;
import ortus.boxlang.runtime.bifs.BoxBIF;
import ortus.boxlang.runtime.context.IBoxContext; // runtime access
import ortus.boxlang.runtime.scopes.ArgumentsScope;
import ortus.boxlang.runtime.scopes.Key;
import ortus.boxlang.runtime.jdbc.DataSource;
import ortus.boxlang.runtime.services.DatasourceService;
import ortus.boxlang.runtime.types.Argument;
import ortus.boxlang.runtime.types.Array;
import ortus.boxlang.runtime.types.IStruct;
import ortus.boxlang.runtime.types.Struct;
import ortus.boxlang.runtime.types.exceptions.BoxRuntimeException;

@BoxBIF( description = "Returns datasource configuration and pool metadata")
public class GetDataSourceMetaData extends BIF {
	// Constructor
	super();
	declaredArguments = new Argument[] {
		new Argument( false, Argument.STRING, Key.datasource )
	}	
	public Object _invoke(IBoxContext context, ArgumentsScope arguments ) {
    	DatasourceService datasourceService = context.getRuntime().getDatasourceService();

		String[] datasourceNames = datasourceService.getNames();
		for (String datasourceName : datasourceNames) {
			DataSource dataSource = DatasourceService.get( Key.of( datasourceName ));
		}
	}
}
