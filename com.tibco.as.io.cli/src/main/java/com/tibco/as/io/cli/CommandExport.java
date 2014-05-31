package com.tibco.as.io.cli;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.beust.jcommander.Parameter;
import com.tibco.as.io.Export;
import com.tibco.as.io.IMetaspaceTransfer;
import com.tibco.as.io.ITransfer;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.browser.BrowserDef.DistributionScope;
import com.tibco.as.space.browser.BrowserDef.TimeScope;

public abstract class CommandExport extends Command {

	@Parameter(description = "The list of spaces to export")
	private Collection<String> spaceNames = new ArrayList<String>();

	@Parameter(description = "Browser time scope", names = { "-time_scope" }, converter = BrowserTimeScopeConverter.class, validateWith = BrowserTimeScopeConverter.class)
	private TimeScope timeScope;

	@Parameter(description = "Browser distribution scope", names = { "-distribution_scope" }, converter = BrowserDistributionScopeConverter.class, validateWith = BrowserDistributionScopeConverter.class)
	private DistributionScope distributionScope;

	@Parameter(description = "Browser timeout", names = { "-timeout" })
	private Long timeout;

	@Parameter(description = "Browser prefetch", names = { "-prefetch" })
	private Long prefetch;

	@Parameter(description = "Browser query limit", names = { "-query_limit" })
	private Long queryLimit;

	@Parameter(description = "Browser filter", names = { "-filter" })
	private String filter;

	public void configure(Export transfer) {
		super.configure(transfer);
		transfer.setTimeScope(timeScope);
		transfer.setDistributionScope(distributionScope);
		transfer.setTimeout(timeout);
		transfer.setPrefetch(prefetch);
		transfer.setQueryLimit(queryLimit);
		transfer.setFilter(filter);
	}

	@Override
	protected Collection<IMetaspaceTransfer> getMetaspaceTransfers(
			Metaspace metaspace) {
		return getMetaspaceTransfers(metaspace, spaceNames);
	}

	@Override
	protected String getExecutingMessage(Collection<ITransfer> transfers) {
		return MessageFormat.format("Exporting {0} space(s)", transfers.size());
	}

	@Override
	protected String getOpenedMessage(ITransfer transfer) {
		return MessageFormat.format("Exporting {0}", transfer.getInputStream()
				.getName());
	}

	@Override
	protected String getClosedMessage(ITransfer transfer) {
		return MessageFormat.format("Exported {0}", transfer.getInputStream()
				.getName());
	}

	protected abstract Collection<IMetaspaceTransfer> getMetaspaceTransfers(
			Metaspace metaspace, Collection<String> spaceNames);

}
