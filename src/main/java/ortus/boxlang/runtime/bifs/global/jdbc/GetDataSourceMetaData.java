package ortus.boxlang.runtime.bifs.global.jdbc;
// BIF FRAMEWORK IMPORTS
import ortus.boxlang.runtime.bifs.BIF;
import ortus.boxlang.runtime.bifs.BoxBIF;
// CONTEXT AND ARGUMENT IMPORTS
import ortus.boxlang.runtime.context.IBoxContext; // runtime access
import ortus.boxlang.runtime.scopes.ArgumentsScope;
import ortus.boxlang.runtime.scopes.Key;
// DATASOURCE SERVICES IMPORT
import ortus.boxlang.runtime.jdbc.DataSource;
import ortus.boxlang.runtime.services.DatasourceService;
// BOXLANG RETURN VALUES AND ARGUMENT DECLARATIONS
import ortus.boxlang.runtime.types.Argument;

@BoxBIF( description = "Returns datasource configuration and pool metadata")
public class GetDataSourceMetaData extends BIF {
	
}
