<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="autok">
		<xsl:for-each select="auto">
			<xsl:for-each select="auto/tulaj">
				<xsl:for-each select="tulaj/varos">
					<xsl:choose>
						<xsl:when test="text() = 'Miskolc'">
							<xsl:value-of select="auto[@rsz]"/>
						</xsl:when>
					</xsl:choose>
				</xsl:for-each>
			</xsl:for-each>
		</xsl:for-each>	
	</xsl:template>
</xsl:stylesheet>