package ortus.boxlang.runtime.bifs.global.jdbc;
import ortus.boxlang.runtime.bifs.BIF;
import ortus.boxlang.runtime.bifs.BoxBIF;
import ortus.boxlang.runtime.context.IBoxContext; // runtime access
import ortus.boxlang.runtime.scopes.ArgumentsScope;
import ortus.boxlang.runtime.scopes.Key;
import ortus.boxlang.runtime.jdbc.DataSource;
import ortus.boxlang.runtime.services.DatasourceService;
import ortus.boxlang.runtime.config.segments.DatasourceConfig;
import ortus.boxlang.runtime.types.Argument;
import ortus.boxlang.runtime.types.Array;
import ortus.boxlang.runtime.types.Struct;
import ortus.boxlang.runtime.types.exceptions.BoxRuntimeException;

@BoxBIF( description = "Returns datasource configuration and pool metadata")
public class GetDataSourceMetaData extends BIF {
	// Constructor
	public GetDataSourceMetaData() {
		super();
		declaredArguments = new Argument[] {
			new Argument( false, Argument.STRING, Key.datasource )
		};
	};	
	public Object _invoke(IBoxContext context, ArgumentsScope arguments ) {
    	DatasourceService datasourceService = context.getRuntime().getDataSourceService();
		String datasourceName = arguments.getAsString( Key.datasource );
		// Get all datasource names from datasource service, then iterate through them to retrieve metadata
		Array metadataArray = new Array();
		String[] datasourceNames = datasourceService.getNames();
		// Check if one specific datasource is requested and return accordingly
		if (datasourceName != null && !datasourceName.isEmpty()) {
			DataSource datasource = datasourceService.get( Key.of( datasourceName ));
			DatasourceConfig configuration = datasource.getConfiguration();

			Struct metadata = Struct.of(
				"datasourceName", datasourceName,
				"configuration", configuration.toConfigStruct(),
				"applicationName", configuration.getApplicationName(),
				"poolStats", datasource.getPoolStats()
			);
			metadataArray.append(metadata);
		} else {
		// Iterate through all datasource names and append metadata to a struct to the metadata array
			for (String datasourceName : datasourceNames) {
			DataSource datasource = datasourceService.get( Key.of( datasourceName ));
			DatasourceConfig configuration = datasource.getConfiguration();

			Struct metadata = Struct.of(
				"datasourceName", datasourceName,
				"configuration", configuration.toConfigStruct(),
				"applicationName", configuration.getApplicationName(),
				"poolStats", datasource.getPoolStats()
			);
			metadataArray.append(metadata);
			}
		}
		return metadataArray;
	};
};
